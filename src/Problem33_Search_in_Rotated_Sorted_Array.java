
public class Problem33_Search_in_Rotated_Sorted_Array {
	public int search(int[] nums, int target) {
        /*not solved by myself*/
        if(nums.length == 0)
            return -1;
        int start = 0;
        int end = nums.length -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(target == nums[mid])
                return mid;
            if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target < nums[mid])
                    end = mid - 1;
                else
                    start += 1;
            }
            else{
                if(nums[mid] < target && target <= nums[end])
                    start = mid + 1;
                else
                    end -= 1;
            }
        }
        return -1;
    }
}
