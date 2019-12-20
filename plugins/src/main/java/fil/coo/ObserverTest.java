package fil.coo;

public class ObserverTest {

    public static void main( String[] args )
    {
    	PrintFileName p = new PrintFileName();
    	FileChecker f = new FileChecker("plugins", new DotClassFilter());
    	f.addFileListener(p);
    	f.startChecking();
    	
    	while(true) {
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
}
