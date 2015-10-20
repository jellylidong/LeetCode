public class Prioblem213_House_Robber_II {
	public int rob_v1(int[] nums) {
        int l = nums.length;
        if(l == 1)
            return nums[0];
        if(l == 2)
            return Math.max(nums[0], nums[1]);
            
        int[][] res = new int[l][l];
        
        //initial value when position 0 is robbed
        res[0][0] = nums[0]; res[0][1] = nums[0];
        res[1][0] = 0;       res[1][1] = 0; //don't forget to add the res[0][0] to final result
        for(int i = 2; i < l-1; i++){
            res[i][0] = Math.max(res[i-1][0], res[i-1][1]);
            res[i][1] = nums[i] + res[i-1][0];
        }
        int res_with_0 = Math.max(res[l-2][0], res[l-2][1]) + res[0][1];
        
        //initial value when position 0 is not robbed
        res[0][0] = 0; res[0][1] = 0;
        res[1][0] = 0;       res[1][1] = nums[1];
        for(int i = 2; i <= l-1; i++){
            res[i][0] = Math.max(res[i-1][0], res[i-1][1]);
            res[i][1] = nums[i] + res[i-1][0];
        }
        int res_without_0 = Math.max(res[l-1][0], res[l-1][1]);
        
        return Math.max(res_with_0, res_without_0);
    }
	
	public int rob_v2(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 0, nums.length-2),
                        rob(nums, 1, nums.length-1));
    }
    
    public int rob(int[] nums, int start, int end){
        int preYes = nums[start];
        int preNo  = 0;
        
        for(int i = start+1; i <= end; i++){
            int curYes = nums[i] + preNo;
            int curNo  = Math.max(preYes, preNo);
            preYes = curYes;
            preNo  = curNo;
        }
        return Math.max(preYes, preNo);
    }
}
