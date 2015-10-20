import java.util.HashMap;


public class Problem219_Contains_Duplicate_II {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!hash.containsKey(nums[i]))
                hash.put(nums[i], i);
            else{
                int tmp = hash.get(nums[i]);
                if(Math.abs(tmp-i) <= k)
                    return true;
                else
                    hash.put(nums[i], i);
            }
        }
        return false;
    }
}
