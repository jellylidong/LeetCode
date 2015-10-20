import java.util.*;
public class Problem202_Happy_Number {
	public static boolean isHappy(int n) {
	       int sum = n;
	       HashSet<Integer> hash = new HashSet<Integer>();
	       hash.add(n);
	       while(sum != 1){
	           sum = sum(sum);
	           if(!hash.contains(sum))
	                hash.add(sum);
	            else return false;
	       }
	       return true;
	    }
	    public static int sum(int n){
	        int sum = 0;
	        String str = Integer.toString(n);
	        for(int i = 0; i < str.length(); i++){
	            int num = str.charAt(i)-48;
	            //System.out.print(num+" ");
	            sum += num*num;
	        }
	        return sum;
	    }
	    
	    public static void main(String[] args){
	    	System.out.println(isHappy(7));
	    	//System.out.print(sum(7));
	    }
}
