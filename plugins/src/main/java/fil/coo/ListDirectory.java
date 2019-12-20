package fil.coo;

import java.io.File;
import java.io.FilenameFilter;

public class ListDirectory {
	
	private File directory;

	public ListDirectory(String path) {
		this.directory = new File(path);

	}

	public String[] listStartingByC() {
		return this.directory.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.startsWith("C");
			}
		});
	}
	
	public String[] listAll() {
		return this.directory.list();
	}

	public String[] listClassFile() {
		return this.directory.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".class");			
			}
		});
	}
}
