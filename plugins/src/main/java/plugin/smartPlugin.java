package plugin;

public class smartPlugin implements Plugin {

	@Override
	public String transform(String s) {
		return "Subscribe to pewdiepie";
	}

	@Override
	public String getLabel() {
		return "SmartPlugin™";
	}

	@Override
	public String helpMessage() {
		return "Do smart things";
	}

}
