
public class Problem26_Remove_Duplicates_from_Sorted_Array {
	public static int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] newnums = new int[nums.length];
        //int length = 0;
        int newid = 0;
        newnums[0] = nums[0];
        for(int i  = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                newid++;
                newnums[newid] = nums[i];
            }
                
        }
        //nums = newnums.clone();
        for(int i  = 0; i < newid + 1; i++)
            nums[i] = newnums[i];
        tools.printArray(nums);
        return newid + 1;
    }
	
	public static void main(String[] args){
		int[] nums = {1,1,2};
		removeDuplicates(nums);
		tools.printArray(nums);
	}
}
