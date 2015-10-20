
public class Problem4_Longest_Common_Prefix {
	public String longestCommonPrefix(String[] strs) {
        String prefix = "" ;
        boolean flag = false;
        for(int j = 0; j < prefix.length()+1 ; j++){
             
             for(int i = 0; i < strs.length; i++){
                 flag = true;
                 if(j > strs[i].length()-1 
                    || !strs[i].substring(j, j+1).equals(strs[0].substring(j, j+1))){
                     flag = false;
                     break;
                 }
             }
             if(flag)
                prefix += strs[0].substring(j, j+1);
        }
        return prefix;
    }
}
