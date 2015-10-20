
public class Problem9_Palindrome_Number {
	 public boolean isPalindrome(int n) {
	        if(n < 0)
	            return false;
	        int rev = 0;
	        int  x =n;
	        while(n != 0){
	            rev = rev*10 + n%10;
	            n /= 10;
	        }
	        return rev == x;
	    }
}
