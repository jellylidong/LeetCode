
public class Problem164_Maximum_Gap {
	public static int maximumGap(int[] nums) {
        int l = nums.length;
        if(l < 2)
            return 0;
        int max = nums[0], min = nums[0];
        for(int i: nums){
            if(i > max) max = i;
            if(i < min) min = i;
        }
        int minGap = (max - min)/(l-1) + 1;
        bucket[] b = new bucket[l];
        for (int j = 0; j < b.length; j++) {
			b[j] = new bucket();
		}
        //System.out.println("test"+b[0].max);
        for(int i : nums){
            int id = (i-min)/minGap;
            if(i > b[id].max)
                b[id].max = i;
            if(i < b[id].min)
                b[id].min = i;
        }
        for(bucket bbb: b){
        	System.out.println(bbb.max+" "+bbb.min);
        }
        int res = b[0].diff();
        int pre = 0;
        int cur = 1;
        while(cur < l){
            if(b[cur].max == Integer.MIN_VALUE)
                cur++;
            else{
                int tmp = Math.max(res, b[cur].min-b[pre].max);
                res = Math.max(tmp, b[cur].diff());
                pre = cur;
                cur++;
            }
        }
        return res;
    }
    
    static class bucket{
        int max ;//= Integer.MIN_VALUE;
        int min ;//= Integer.MAX_VALUE;
        bucket(){
        	max = Integer.MIN_VALUE;
        	min = Integer.MAX_VALUE;
        }
        int diff(){
            if(max == Integer.MIN_VALUE && min == Integer.MAX_VALUE)
                return Integer.MIN_VALUE;
            return max -min;
        }
    }
    
    public static void main(String[] args){
    	int[] n = {1,100,9, 200, 100000,50000};
    	int res = maximumGap(n);
    	System.out.println(res);
    	//bucket ss = new bucket();
    	//System.out.print(ss.max);
    }
}
