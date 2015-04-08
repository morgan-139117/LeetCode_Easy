package easy;

import java.util.LinkedList;
import java.util.List;

public class ValidParentheses {
	 
	public boolean isPair(char either, char other){
		
		if(either == '(' && other == ')') return true;
		
		if(either == '[' && other == ']') return true;
			
		if(either == '{' && other == '}') return true;
		
		return false;
	}
	
	public boolean isValid(String s) {
		
		if(s.length() == 1) return false;
		List<Character> testString = new LinkedList<Character>();
		testString.add(s.charAt(0));
		for(int i = 1; i < s.length(); i ++){
			if(testString.size() != 0){//didn't realize the case when all element got popped out in the middle
				if(isPair(testString.get(testString.size() - 1),s.charAt(i)))//List has size other than length, List has get rather than charAt
				{
					testString.remove(testString.size() - 1);//this is how to use .size() to access the last element
				}else{
					testString.add(s.charAt(i));
				}
			}else{
				testString.add(s.charAt(i));
			}
		}
		if(testString.size() == 0) return true;
		return false;
    }
	
	
	public static void main(String[] args){
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid(new String("()[]{}")));
	}
}
