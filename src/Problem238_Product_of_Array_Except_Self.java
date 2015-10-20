
public class Problem238_Product_of_Array_Except_Self {
	public int[] productExceptSelf(int[] nums) {
	    int[] res = new int[nums.length];
	    res[0] = 1;
	    for(int i = 1; i < nums.length; i++){
	    	res[i] = res[i-1] * nums[i-1];
	    }
	    int tmp = 1;
	    for(int i = nums.length-1; i >= 0; i--){
	    	res[i] *= tmp;
	    	tmp *= nums[i];
	    }
	    return res;
	}
}
