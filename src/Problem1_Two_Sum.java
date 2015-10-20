import java.util.*;
public class Problem1_Two_Sum {
	// O(n^2) run time, terrible 
	/*
	public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(i != j && nums[i] + nums[j] == target){
                    res[0] = Math.min(i+1,j+1);
                    res[1] = Math.max(i+1,j+1);
                    return res;
                }
            }
        }
        return res;
    }
	*/
	
	// very clever O(n) run time
	public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0 ; i < nums.length; i++){
            if(hash.containsKey(target - nums[i])){
                res[0] = hash.get(target - nums[i]) + 1;
                res[1] = i+1;
                return res;
            }
            hash.put(nums[i], i);
        }
        return res;
    }
}
