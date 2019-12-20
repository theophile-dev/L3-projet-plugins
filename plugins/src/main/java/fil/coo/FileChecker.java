package fil.coo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.Timer;


public class FileChecker {
	
	private class ActionPerformed implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String[] scannedFiles = directory.list(filenamefilter);
			HandleNewFiles(new ArrayList<String>(Arrays.asList(scannedFiles)));
		}

	}
	private ArrayList<FileListener> fileListenerArray;
	
	private FilenameFilter filenamefilter;
	private HashSet<String> currentFiles;
	private File directory;
	private Timer timer;
	
	public FileChecker(String directoryToCheck, FilenameFilter filenamefilter) {
		this.currentFiles = new HashSet<String>();
		this.fileListenerArray = new ArrayList<FileListener>();
		this.filenamefilter = filenamefilter;
		this.directory =new File(directoryToCheck);
		this.timer = new Timer(250, new ActionPerformed());
		this.timer.start();
		
	}

	public void addFileListener(FileListener fileListener) {
		fileListenerArray.add(fileListener);
	}
	
	public void removeFileListener(FileListener fileListener) {
		fileListenerArray.remove(fileListener);
	}
	
	public void fireFileAdded(String fileName) {
		for(FileListener fileListener: fileListenerArray) {
			fileListener.fileAdded(new FileEvent(fileListener, fileName));
		}
	}
	
	public void fireFileRemoved(String fileName) {
		for(FileListener fileListener: fileListenerArray) {
			fileListener.fileRemoved(new FileEvent(fileListener, fileName));
		}
	}
	/**
	 * HandleNewFiles add and remove file from currentFiles and fire the call 
	 * fireFileAdded and fireFileRemoved when necessary.
	 * @param fileChecked the newly scanned files
	 */
	public void HandleNewFiles(ArrayList<String> fileChecked){
		for(String filename : fileChecked) {
			// If currentFiles does not contains this element 
			// it means this file has been added since last check
			if (!currentFiles.contains(filename)) {
				fireFileAdded(filename);
				currentFiles.add(filename);
			}
		}
		
		for(String filename : currentFiles) {
			// If fileChecked does not contains this element 
			// it means this file has been removed since last check
			if (!fileChecked.contains(filename)) {
				fireFileRemoved(filename);
				currentFiles.remove(filename);
			}
		}
	}
}
