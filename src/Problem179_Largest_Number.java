import java.util.Arrays;
import java.util.Comparator;

public  class Problem179_Largest_Number {
	public static String largestNumber(int[] nums) {
        if(nums.length == 0)
            return "";
        String[] ss = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            ss[i] = Integer.toString(nums[i]);
        Comparator<String> cp = new Comparator<String>(){
        	public int compare(String a, String b){
                String s1 = a+b;
                String s2 = b+a;
                return s1.compareTo(s2);
            }
        };
        
        
        Arrays.sort(ss, cp);
        if(ss[ss.length-1].charAt(0) == '0')
        	return "0";
        StringBuilder sb = new StringBuilder();
        for(String s: ss)
            sb.insert(0,s);
        return sb.toString();
    }
	
	public static void main(String[] args){
		int[] nums = {3, 30, 34, 5, 9};
		String res = largestNumber(nums); 
		System.out.println(res);
	}
}
