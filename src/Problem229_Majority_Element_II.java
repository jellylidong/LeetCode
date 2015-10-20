import java.util.*;
public class Problem229_Majority_Element_II {
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        int count1 =0, count2 = 0;
        int candy1 = nums[0];
        int candy2 = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == candy1)
                count1++;
            else if(nums[i] == candy2)
                count2++;
            else if(count1 == 0){
                candy1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0){
                candy2 = nums[i];
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        //must count, or like [3,2,3] the 2 is int the result, but actually not
        /*if(count1 != 0)
            res.add(candy1);
        if(count2 != 0)
            res.add(candy2);*/
        count1 = 0;
        count2 = 0;
        for(int i=0; i < nums.length; i++ ){
            if(nums[i] == candy1)
                count1++;
            if(nums[i] == candy2)
                count2++;
            
        }
        if(count1 > nums.length/3)
            res.add(candy1);
        if(count2 > nums.length/3 && !res.contains(candy2)) // for [1], use res.contains() to make sure no duplicate number is added
            res.add(candy2);
        return res;
    }
}
