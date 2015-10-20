import java.util.*;
public class Problrm15_3Sum {
	 public List<List<Integer>> threeSum(int[] nums) {
	        Arrays.sort(nums);
	        List<List<Integer>> res = new ArrayList<>();
	        for(int i = 0; i < nums.length;){
	            int start = i+1, end = nums.length-1;
	            while(start < end){
	                if(nums[i] + nums[start] + nums[end] == 0){
	                    List<Integer> list = new ArrayList<>();
	                    list.add(nums[i]);  list.add(nums[start]);  list.add(nums[end]);
	                    res.add(list);
	                    start++;
	                    end--;
	                    
	                    while(start < end && nums[start] == nums[start-1])  start++;
	                    while(start < end && nums[end] == nums[end+1]) end--;
	                }
	                else if(nums[i] + nums[start] + nums[end] > 0){
	                    end--;
	                    while(start < end && nums[end] == nums[end+1])
	                        end--;
	                }
	                else{
	                    start++;
	                     while(start < end && nums[start] == nums[start-1])  start++;
	                }
	            }
	            i++;
	            while(i < nums.length && nums[i] == nums[i-1])
	                i++;
	        }
	        return res;
	    }
}
