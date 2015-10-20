
public class Problem75_Sort_Colors {
	public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for(int i  = 0; i < nums.length; i++){
            switch (nums[i]){
                case 0: red++;  break;
                case 1: white++;    break;
                case 2: blue++;  break;
                default:    break;
            }
        }
        for(int i  = 0; i < nums.length; i++){
            if(i < red)
                nums[i] = 0;
            else if(i < red+white && i >= red)
                nums[i] = 1;
            else if(i >= red+ white)
                nums[i] = 2;
        }
    }
}
