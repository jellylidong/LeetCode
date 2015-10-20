
public class Problem125_Valid_Palindrome {
	public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start < s.length() && end >= 0 && start <= end){
            char ss = lower(s.charAt(start));
            char ee = lower(s.charAt(end  ));
            if(!(ss >= 'a' && ss<= 'z') && !(ss >= '0' && ss <= '9'))
                start++;
            else if(!(ee >= 'a' && ee <= 'z') && !(ee >= '0' && ee <= '9'))
                end--;
            else if(ss != ee)
                return false;
            else{
                start++;
                end--;
            }
        }
        return true;
    }
    
    /*public String filter(String str){
        String s = str.toLowerCase();
        String res = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if((c >= '0' && c <= '9') || (c >= 'a' && c<= 'z'))
                res += String.valueOf(c);
        }
        return res;
    }*/
    
    public char lower(char c){
        if(!(c >= 'A' && c <= 'Z'))
            return c;
        else
            return Character.toLowerCase(c);
    }
}
