
public class Problem41_First_Missing_Positive {
	public static int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length;){
            
            if(nums[i] > 0 && 
               nums[i] != i+1 && 
               nums[i] <= nums.length && 
               nums[i] != nums[nums[i]-1]){
                int tmp = nums[i];
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;
                //i = nums[i]-1;
                
            }
            else
                i++;
            //System.out.println(i);
            //tools.printArray(nums);
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
    }
	
	public static void main(String[]  args){
		int[] nums = {6,9,8,7,7,7,7,7,5,5,4,3,2,1};
		int res = firstMissingPositive(nums);
		System.out.println(res);
	}
}
