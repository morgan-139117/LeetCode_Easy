package easy;

public class HammingWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int hammingWeight(int n) {
		
		
		
		int remain;
		int cnt = 0;//java int needs initialization
		while(n > 1){
			remain = n %10;
			if(remain == 1)
				cnt++;
			n = n >> 1;
		}
		if (n == 1) cnt++;
		
		return cnt;
	}
}
