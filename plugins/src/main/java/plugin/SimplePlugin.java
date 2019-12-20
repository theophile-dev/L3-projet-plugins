package plugin;

public class SimplePlugin implements Plugin {
	
		private String res;
		
		private String label;
		
		private String help;
	
		public SimplePlugin() {
			this.res = "Subscribe to pewdiepie";
			this.label = "SimplePlugin";
			this.help = "Do smart things";
		}

		@Override
		public String transform(String s) {
			return this.res;
		}

		@Override
		public String getLabel() {
			return label;
		}

		@Override
		public String helpMessage() {
			return help;
		}

}



