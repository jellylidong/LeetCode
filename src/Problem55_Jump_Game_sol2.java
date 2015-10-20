
public class Problem55_Jump_Game_sol2 {
	public static boolean canJump(int[] nums) {
		int length = nums.length;
		if(length == 0)
            return false;
        if(length == 1)
            return true;
		boolean[] reachable = new boolean[length];
		for(int i = 0; i < length; i++){
			if(i >0){
				if(reachable[i] == false)
					return false;
			}
			for(int j = 1; j <= nums[i]; j++){
				if(i+j == length-1)
					return true;
				reachable[i+j] = true;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
    	int[] A = {3,2,1,0,4};
    	System.out.print(canJump(A));
    }
}
