package fil.coo;

import java.util.EventObject;

public class FileEvent extends EventObject{


	private static final long serialVersionUID = -6823567768930559494L;
	
	private String filename;
	
	public FileEvent(Object source, String filename) {
		super(source);
		this.filename = filename;
	}
	
	public String getFileName() {
		return filename;
	}

}
