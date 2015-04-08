package easy;

public class ReadOff {

	public StringBuilder readoff(StringBuilder sourceStrBuilder) {

		StringBuilder tempStrBuilder = new StringBuilder();

		for (int i = 0; i < sourceStrBuilder.length(); i++) {
			// current char @ source is 2 which reads as 12
			if (sourceStrBuilder.charAt(i) == '2') {
				tempStrBuilder.append('1');
				tempStrBuilder.append('2');
			}
			// current char @ source is 1
			else {
				// if the current 1 is the last one which should read as 11
				if ((i + 1) == sourceStrBuilder.length()) {
					tempStrBuilder.append('1');
					tempStrBuilder.append('1');
				} else {
					// the next char @ source is 1, which should be interpreted
					// as '11' which reads as 21
					if (sourceStrBuilder.charAt(i + 1) == '1') {
						tempStrBuilder.append('2');
						tempStrBuilder.append('1');
						i++;
					} else {
						tempStrBuilder.append('1');
						tempStrBuilder.append('1');

						tempStrBuilder.append('1');
						tempStrBuilder.append('2');
						i++;
					}
				}
			}

		}
		return tempStrBuilder;
	}

	public String countAndSay(int n) {

		if (n == 0)
			return new String("0");
		if (n == 1)
			return new String("1");
		StringBuilder sequenceStrBuilder = new StringBuilder();
		sequenceStrBuilder.append("1");
		for (int i = 1; i < n; i++) {
			sequenceStrBuilder=	readoff(sequenceStrBuilder);
			// for (int j = 0 ; j < sec.length && sec[j] !='\0'; j++)
			// System.out.print("  "+ sec[j] + ",");
			// System.out.println();

		}
		return sequenceStrBuilder.toString();
	}

	public static void main(String[] args) {

		ReadOff rf = new ReadOff();
		System.out.println(rf.countAndSay(25).toString());

	}
}
