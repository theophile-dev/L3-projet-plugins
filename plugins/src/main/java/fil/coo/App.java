package fil.coo;

public class App 
{
    public static void main( String[] args )
    {
    	PrintFileName printer = new PrintFileName();
    	FileChecker fileChecker = new FileChecker("plugins", new DotClassFilter());
    	fileChecker.addFileListener(printer);
    	new Editor("amazing default text", fileChecker);

    	
    }
}
