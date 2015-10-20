import java.util.*;
public class Problem18_4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; ){
            for(int j = i+1; j < nums.length;){
                int start = j+1;
                int end = nums.length-1;
                while(start < end){
                    if(nums[i] + nums[j] + nums[start] + nums[end] == target){
                        List<Integer> list =  new ArrayList<>();
                        list.add(nums[i]); list.add(nums[j]); list.add(nums[start]); list.add(nums[end]);
                        res.add(list);
                        start++;
                        end--;
                        while(start < end && nums[start] == nums[start-1]) start++;
                        while(start < end && nums[end] == nums[end+1]) end--;
                    }
                    else if(nums[i] + nums[j] + nums[start] + nums[end] < target){
                        start++;
                        while(start < end && nums[start] == nums[start-1]) start++;
                    }
                    else{
                        end--;
                        while(start < end && nums[end] == nums[end+1]) end--;
                    }
                }
                j++;
                while(j < nums.length && nums[j] == nums[j-1])  j++;
            }
            i++;
            while(i < nums.length && nums[i] == nums[i-1]) i++;
        }
        return res;
    }
}
