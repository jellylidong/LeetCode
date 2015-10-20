
public class Problem132_Palindrome_Partitioning_II {
	public int minCut_TypeAgain(String s){
		int l = s.length();
		if(l <= 1)
			return 0;
		int[] cut = new int[l];
		boolean[][] isP = new boolean[l][l];
		
		for(int i = l-1; i >= 0; i--){
			cut[i] = l-i-1;
			for(int j = i; j < l; j++){
				if( (s.charAt(i) == s.charAt(j)) && (j-i <= 1 || isP[i+1][j-1])){
					isP[i][j] = true;
					if(j == l-1)	cut[i] = 0;
					else cut[i] = Math.min(cut[i], 1+cut[j+1]);
				}
			}
		}
		return cut[0];
	}
	
	public int minCut(String s) {
        int l = s.length();
        if(l <= 1)
            return 0;
        boolean[][] isP = new boolean[l][l];
        int[] cut = new int[l]; 
        
        
        for(int i = l-1; i >= 0; i--){
            cut[i] = l-i-1; // the worst case is that for string [i, j] (both i and j are inclusive) is j-i-1
                            // initial cut[i] means the worst case we cut  the s.substring(i)
            for(int j = i; j < l; j++){
                //isP[i][j] = false;
                if((s.charAt(i) == s.charAt(j)) 
                    && (j-i <= 1 || isP[i+1][j-1])){ // if j == i, one char is Palindrome
                									//if j-i == 1, since s[i] == s[j] it's a Palindrome
                									//if don't use this condition, when j=0 or i=l-1, OutOfBoundaryExceptions happens
                    //cut[i] = Math.min(cut[i], 1+cut[j+1]); // the min cut of s.substring(i)
                    isP[i][j] = true;
                    if(j == l-1)    cut[i] = 0; 
                    else cut[i] = Math.min(cut[i], 1+cut[j+1]);
                        
                }
            }
            
        }
        return cut[0];
    }
}
