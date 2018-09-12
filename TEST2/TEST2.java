public class TEST2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	} 

	public static int solution(int N) {
		
		// String To Binary Num
		String bin = Integer.toBinaryString(N); 
		
		int count_one = 0;
		int count_zero = 0;
		int saveCount_zero = 0;
		
		// Check
		for (int i = 0 ; i < bin.length() ; i++) {
			if (bin.charAt(i) == '1'){
				count_one++;
				if (saveCount_zero < count_zero) {
					saveCount_zero = count_zero;
				}
				count_zero = 0;
			} else if (bin.charAt(i) == '0') {
				count_zero++;
			} 
		}
		
		// return
		if (count_one == 1) {
			return 0;
		} else {
			return saveCount_zero;
		}
		
	}
}

