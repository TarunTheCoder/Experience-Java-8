package academy.elqoo.java8.stream.sample;


public class CommaSeparatedNameCreator {
		private String finalString = "";
		private final String COMMA = ", ";
		
		public void accept(String name) {
			if(finalString.isEmpty()) {
				finalString +=name;
			}else {
				finalString += COMMA+name;
			}
		}
		
		public void combiner(CommaSeparatedNameCreator  other) {
			
		}
		
		public String getCommaSeparatedNames() {
			return finalString;
		}

}
