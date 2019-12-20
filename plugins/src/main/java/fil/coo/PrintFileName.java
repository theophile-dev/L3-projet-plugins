package fil.coo;

public class PrintFileName implements FileListener {

	@Override
	public void fileAdded(FileEvent event) {
		System.out.println(java.util.Calendar.getInstance().getTime()+" add :"+event.getFileName());
	}

	@Override
	public void fileRemoved(FileEvent event) {
		System.out.println(java.util.Calendar.getInstance().getTime()+" rm : "+event.getFileName());
	}
	
}
