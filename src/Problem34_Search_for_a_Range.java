
public class Problem34_Search_for_a_Range {
	public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end  = nums.length-1;
        int[] res = {-1, -1};
        searchRange(start, end, nums, target, res);
        return res;
    }
    
    public void searchRange(int start, int end, int[] nums, int target, int[] res){
        if(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                if(res[0] == -1 || res[0] > mid)
                    res[0] = mid;
                if(res[1] < mid)
                    res[1] = mid;
            }
            if(mid-1 >= 0)
                if(nums[mid-1] >= target)
                   searchRange(start, mid-1, nums, target, res);
            if(mid+1 <= end)
                if(nums[mid+1] <= target)
                   searchRange(mid+1, end, nums, target, res); 
        }
    }
}
