
public class Problem97_Interleaving_String {
	public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        
        boolean[][] res = new boolean[s1.length()+1][s2.length()+1];
        res[0][0] = true;
        for(int i = 1; i < res[0].length; i++){
            res[0][i] = s2.charAt(i-1) == s3.charAt(i-1) && res[0][i-1];
        }
        for(int i = 1; i < res.length; i++){
            res[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && res[i-1][0];
        }
        for(int i = 1; i < res[0].length; i++){
            for(int j = 1; j < res.length; j++){
                res[j][i] = (s1.charAt(j-1) == s3.charAt(i+j-1) && res[j-1][i])||
                            (s2.charAt(i-1) == s3.charAt(i+j-1) && res[j][i-1]);
            }
        }
        return res[s1.length()][s2.length()];
    }
}
