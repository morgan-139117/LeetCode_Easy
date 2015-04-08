package easy;

public class ReadOff {

	public StringBuilder readoff(StringBuilder sourceStrBuilder) {

		StringBuilder tempStrBuilder = new StringBuilder();
		
		boolean changed = true;
		int continued = 0;
		
		for (int i = 0; i < sourceStrBuilder.length(); i++) {			
					
			//a new char
			if(changed == true)
			{//current char is the last one
				if(i+1 == sourceStrBuilder.length()){
					tempStrBuilder.append('1');
					tempStrBuilder.append(sourceStrBuilder.charAt(i));
				}else{
					if(sourceStrBuilder.charAt(i) == sourceStrBuilder.charAt(i+ 1)){
						continued++;
						changed = false;
					}else{
						tempStrBuilder.append(++continued);
						tempStrBuilder.append(sourceStrBuilder.charAt(i));
						changed = true;
						continued = 0;
					}
				}
			
			}else{//a continued char
				//current char is the last one
				if(i+1 == sourceStrBuilder.length()){
					tempStrBuilder.append(++continued);
					tempStrBuilder.append(sourceStrBuilder.charAt(i));
				}else{
					if(sourceStrBuilder.charAt(i) == sourceStrBuilder.charAt(i+ 1)){
						continued++;
					}else{
						tempStrBuilder.append(++continued);
						tempStrBuilder.append(sourceStrBuilder.charAt(i));
						continued =0 ;//forgot to reset it to zero after detect a non-continuous char
						changed = false;//forgot to reset to false after detect a non-continuous char
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
			 for (int j = 0 ; j < sequenceStrBuilder.length() ; j++)
			   System.out.print("  "+ sequenceStrBuilder.charAt(j) + ",");
			   System.out.println();
		}
		return sequenceStrBuilder.toString();
	}

	public static void main(String[] args) {

		ReadOff rf = new ReadOff();
		System.out.println(rf.countAndSay(10).toString());

	}
}
