
public class Problem38_Count_and_Say {
	public String countAndSay(int n) {
        String res = "1";
        for(int i = 2; i <= n; i++){
            String newStr = "";
            int count = 1;
            for(int j = 1; j <= res.length();){
                if(j == res.length()){
                    newStr += Integer.toString(count) + res.substring(j-1, j);
                }
                    
                else if(res.charAt(j) == res.charAt(j-1))
                    count++;
                else{
                    newStr += Integer.toString(count) + res.substring(j-1, j);
                    count = 1;
                }
                j++;
            }
            res = newStr;
        }
        return res;
    }
}
