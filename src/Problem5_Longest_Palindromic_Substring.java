
public class Problem5_Longest_Palindromic_Substring {
	StringBuilder res = new StringBuilder();
    public String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;
        for(int i = 0; i < s.length(); i++){
            make(s, i, i);
            make(s, i, i+1);
        }
        return res.toString();
    }
    
    public void make(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            
            if(end-start+1 > res.length()){
                res.delete(0, res.length());
                res.append(s.substring(start, end+1));
            }
            
            start--;
            end++;
        }
    }
}
