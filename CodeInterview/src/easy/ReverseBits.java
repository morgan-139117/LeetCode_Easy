package easy;

public class ReverseBits {

	
	public int reverseBits(unsigned long n) {
        if (n == 0) return 0;
        
        String src = Integer.toBinaryString(n);
        
        
        StringBuilder resBuilder = new StringBuilder();
        for(int i = src.length() - 1 ; i >= 0; i --){
            resBuilder.append(src.charAt(i));
        }
        return Integer.parseInt(resBuilder.toString(),resBuilder.length());
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseBits rb = new ReverseBits();
		rb.reverseBits(4294967295);
	}

}
