import java.util.*;
public class Problem228_Summary_Ranges {
	public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        int start = 0;
        int end = start+1;
        while(end < nums.length){
            while(end < nums.length && (nums[end] - nums[end-1]) == 1)
                end++;
            
            String range = "";
            if(start == end-1){
                range = Integer.toString(nums[start]);
                res.add(range);
            }
            else{
                range = Integer.toString(nums[start]) + "->" + Integer.toString(nums[end-1]);
                res.add(range);
            }
            start = end;
            end++;
        }
        if(start < nums.length && start == end-1){
            res.add(Integer.toString(nums[start]));
        }
        return res;
    }
	
	public static void main(String[] args){
		int[] nums = {0,1,2,3,4,5,7,8};
		List<String> res = summaryRanges(nums);
		tools.printList(res);
	}
}
