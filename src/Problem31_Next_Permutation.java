import java.util.Arrays;

public class Problem31_Next_Permutation {
	public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        for(;i >= 0; i--){
            if( i == 0)
                break;
            if(nums[i-1] < nums[i])
                break;
        }
        
        if(i == 0)
            Arrays.sort(nums);
        else{
            int a = i-1;
            int min = nums[i];
            int minid = i;
            for(int j =i; j < nums.length; j++){
                if(nums[j] > nums[a] && nums[j] < min){
                    min = nums[j];
                    minid = j;
                }
            }
            int tmp = nums[a];
            nums[a] = nums[minid];
            nums[minid] = tmp;
            Arrays.sort(nums, i, nums.length);
        }
    }
}
