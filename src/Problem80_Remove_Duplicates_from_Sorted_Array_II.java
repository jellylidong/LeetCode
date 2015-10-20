
public class Problem80_Remove_Duplicates_from_Sorted_Array_II {
	public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] newnums = new int[nums.length];
        int counter = 1;
        int newid = 0;
        newnums[0] = nums[0];
        for(int i = 1; i < nums.length;){
            if(nums[i] == nums[i-1])
                counter++;
            else counter = 1;
            if(counter > 2){
                i++;
                continue;
            }
            newid++;
            newnums[newid] = nums[i];
            i++;
        }
        for(int i = 0; i < newid+1; i++)
            nums[i] = newnums[i];
        return newid + 1;
    }
	
	public static int removeDuplicates2(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] newnums = new int[nums.length];
        int counter = 1;
        int newid = 0;
        newnums[0] = nums[0];
        for(int i = 1; i < nums.length;){
            if(nums[i] == nums[i-1])
                counter++;
            else counter = 1;
            if(counter > 2){
                i++;
                continue;
            }
            newid++;
            nums[newid] = nums[i];
            i++;
        }
        return newid + 1;
    }
	
	public static void main(String[] args){
		int[] nums ={1,1,2,2,2,3,4,5,5,5,5,5,6};
		int count = removeDuplicates2(nums);
		System.out.println(count);
		tools.printArray(nums);
	}
}
