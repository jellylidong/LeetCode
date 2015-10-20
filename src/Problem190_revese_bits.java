

public class Problem190_revese_bits {
	public static int reverseBits(int n) {
        int res = 0;
        int count = 32;
        while(count > 0){
            int remain = n%2;
            res = 2*res + remain;
            System.out.println(Integer.toBinaryString(res));
            n /= 2;
            count--;
        }
        return res;
    }
	
	public static void main(String[] args){
		reverseBits(2147483648);
	}
}
// (1000 0000 0000 0000 0000 0000 0000 0000)