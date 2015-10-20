

public class Problem45_Jump_Game_II {
	public int jump(int[] nums) {
        int maxReach = nums[0];
        int minStep = 0;
        int edge = 0;
        
        for(int i = 1; i < nums.length; i++){
            if(i > edge){
                minStep++;
                edge = maxReach;
                if(edge >= nums.length-1)
                    return minStep;
            }
            maxReach = Math.max(maxReach, i+nums[i]);
            if(maxReach == i)
                return -1;
        }
        return minStep;
    }
}
