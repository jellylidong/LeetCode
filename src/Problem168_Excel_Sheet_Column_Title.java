
public class Problem168_Excel_Sheet_Column_Title {
	public static void main(String []args){
        System.out.println(convertToTitle(17631));
     }
     public static String convertToTitle(int n) {
        if(n <= 0)
            return "";
        String[] table = new String[26];
        for(int i = 0; i < 26; i++){
            table[i] = Character.toString((char)('A'+i));
        }
        StringBuilder res = new StringBuilder();
        
    	while(n>0){
    		n--;
    		res.insert(0, (char)('A'+n%26));
    		n /= 26;
    	}
        
        
        return res.toString();
    }
     
}
