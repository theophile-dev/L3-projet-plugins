package plugin;

public class SpamPlugin implements Plugin {

	@Override
	public String transform(String s) {
		// TODO Auto-generated method stub
		return "aaaaaaaaaaaaaaaaaahgukljlmiopùedfvmofvkmùovkmeùfvmùfvokfvkomùfvdsommùfmgùdlvkdfùmlvdklm";
	}

	@Override
	public String getLabel() {
		return "Spam plugin";
	}

	@Override
	public String helpMessage() {
		// TODO Auto-generated method stub
		return "mlkjmlkjmlkjmlkjmlkjmlk";
	}

}
