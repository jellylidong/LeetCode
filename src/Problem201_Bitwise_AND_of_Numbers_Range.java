
public class Problem201_Bitwise_AND_of_Numbers_Range {
	 public int rangeBitwiseAnd(int m, int n) {
	        int mask = Integer.MAX_VALUE;
	        while((mask&m) != (mask&n))
	            mask <<= 1;
	        return mask&m;
	    }
}
