package leetcode;

public class Problem264_Ugly_Number_II {
	public static int nthUglyNumber(int n) {
        if(n <= 0)
            return -1;
        
        int[] res = new int[n];
        res[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        for(int i = 1; i < n; i++){
            int min = Math.min(n2, Math.min(n3, n5));
            res[i] = min;
            if(min == n2)
                n2 = 2*res[++i2];
            if(min == n3)
                n3 = 3*res[++i3];
            if(min == n5)
                n5 = 5*res[++i5];
        }
        return res[n-1];
    }
	
	public static void main(String[] args){
		int res = nthUglyNumber(11);
		System.out.println(res);
	}
}
