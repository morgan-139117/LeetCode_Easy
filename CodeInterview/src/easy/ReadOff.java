package easy;

public class ReadOff {

	public char[] readoff(char[] sec) {

		char[] temp = new char[sec.length * 2];
		int j = 0;
		for (int i = 0;i < sec.length && sec[i] != ' '; i++) {
			if (sec[i] == '2') {// char equation test mush use ''
				temp[j++] = '1';
				temp[j++] = '2';
			} else if (sec[i] == '1') {
				// if(sec[i+1] == 1){//be very careful with such operating Array out of
				// bounds

				if ((i + 1) < sec.length && sec[i + 1] != '\0') {//java char array empty equals to \0
					//if (sec[i + 1] == 1) {// char equation test mush use ''
					
					if (sec[i + 1] == '1') {
					temp[j++] = '2';
						temp[j++] = '1';
						i++;
					} else {
						temp[j++] = '1';
						temp[j++] = '1';
						temp[j++] = '1';
						temp[j++] = '2';
						i++;
					}
				} else {
					temp[j++] = '1';
					temp[j++] = '1';
				}
			}
		}
		return temp;
	}

	public String countAndSay(int n) {

		if (n == 0)
			return new String("0");
		if (n == 1)
			return new String("1");
		char[] sec = { '1' };
		for (int i = 0; i < n; i++) {
			sec = readoff(sec);
			for (int j = 0 ; j < sec.length && sec[j] !='\0'; j++)
				System.out.print("  "+ sec[j] + ",");
			System.out.println();

		}
		return new String(sec);
	}

	public static void main(String[] args) {

		ReadOff rf = new ReadOff();
		System.out.println(rf.countAndSay(25));

	}
}
