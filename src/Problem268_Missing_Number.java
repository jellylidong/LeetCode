
public class Problem268_Missing_Number {
	public static int missingNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++)
            res ^= nums[i];
        return res;
    }
	
	public static void main(String[] args){
		int[] nums = {0,1,2,3,4};
		int res = missingNumber(nums);
		System.out.println(res);
	}
}
