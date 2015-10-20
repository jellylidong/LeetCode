
public class Problem162_Find_Peak_Element {
	public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        else{
            if(nums[0] > nums[1])
                return 0;
            if(nums[nums.length - 1] > nums[nums.length - 2])
                return nums.length - 1;
        }
        
        return search(1, nums.length-2, nums);
    }
    
    private int search(int start, int end, int[] nums){
        if(nums[start] > nums[start+1] && nums[start] > nums[start-1])
            return start;
        else if(nums[end] > nums[end-1] && nums[end] > nums[end+1])
            return end;
        else if(start >= end)
            return Integer.MIN_VALUE;
        return Math.max( search(start, (start+end)/2, nums), search((start+end)/2+1, end, nums) );
    }
}
