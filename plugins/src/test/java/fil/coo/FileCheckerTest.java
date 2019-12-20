package fil.coo;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileCheckerTest {
	
	private  FileCounter fileCounter;
	private  FileChecker fileChecker;
	
	public class FileCounter implements FileListener {
		
		private int nbFile = 0;

		@Override
		public void fileAdded(FileEvent event) {
			nbFile++;
			System.out.println(event.getFileName());

		}

		@Override
		public void fileRemoved(FileEvent event) {
			nbFile--;

		}
		
		public int getnbFile() {
			return nbFile;
		}

	}
	
	@Before
	public void setup() {
		fileCounter = new FileCounter();
		fileChecker = new FileChecker("plugins", new DotClassFilter());
		fileChecker.addFileListener(fileCounter);
	}
	
	@After
	public void clean() {
		fileChecker.removeFileListener(fileCounter);
	}

	@Test
	public void FileAddedTest() {
		File f1 = new File("./plugins/test.class");
		// delete file is exist
		f1.delete();
		// we wait the fileCounter to be updated
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int nbFile = fileCounter.getnbFile();
		
		// we create a new file
		try {
			f1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// we wait the fileCounter to be updated
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int newNbFile = fileCounter.getnbFile();
		f1.delete();
		assertEquals(nbFile+1,fileCounter.getnbFile());
		
	}
	
	@Test
	public void FileRemovedTest() {
		File f1 = new File("./plugins/test.class");
		// create the file 
		try {
			f1.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// we wait the fileCounter to be updated
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int nbFile = fileCounter.getnbFile();
		
		// we delete the file
		f1.delete();
		
		// we wait the fileCounter to be updated
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int newNbFile = fileCounter.getnbFile();
		f1.delete();
		assertEquals(nbFile-1,fileCounter.getnbFile());
		
	}
	

}
