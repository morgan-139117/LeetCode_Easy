package easy;

public class ReadOff {

	public StringBuilder readoff(StringBuilder srcBuilder) {

		StringBuilder tmpBuilder = new StringBuilder();
		int cont = 1;
		//int charTest = srcBuilder.charAt(0); second bug
		char charTest = srcBuilder.charAt(0);
		
		for (int i = 1; i < srcBuilder.length(); i++) {

			if (srcBuilder.charAt(i) == charTest)
				cont++;
			else {
				tmpBuilder.append(cont).append(charTest);
				cont = 1;
				charTest = srcBuilder.charAt(i);
			}
			//tmpBuilder.append(cont).append((int)charTest); this was the first bug
		}
		//tmpBuilder.append(cont).append((int)charTest); third mistake , takes it as granted convert to int which is exact opposite of what I need to do
		tmpBuilder.append(cont).append(charTest);
		return tmpBuilder;
	}

	public String countAndSay(int n) {

		if (n == 0)
			return new String("0");
		if (n == 1)
			return new String("1");
		StringBuilder sequenceStrBuilder = new StringBuilder();
		sequenceStrBuilder.append("1");
		for (int i = 1; i < n; i++) {
			sequenceStrBuilder = readoff(sequenceStrBuilder);
			for (int j = 0; j < sequenceStrBuilder.length(); j++)
				System.out.print("  " + sequenceStrBuilder.charAt(j) + ",");
			System.out.println();
		}
		return sequenceStrBuilder.toString();
	}

	public static void main(String[] args) {

		ReadOff rf = new ReadOff();
		System.out.println(rf.countAndSay(6).toString());

	}
}
