
public class Problem10_Regular_Expression_Matching {
	public boolean isMatch(String s, String p) {
        // don't understand
        // if(p.isEmpty())
        //     return s.isEmpty();
        
        // if(p.length() == 1 || p.charAt(1) != '*'){
        //     if(s.isEmpty() ||
        //       (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0)))
        //       return false;
        //     else
        //         return isMatch(s.substring(1), p.substring(1));
        // }
        
        // while(!s.isEmpty() &&
        //       (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')){
        //     if(isMatch(s, p.substring(2)))
        //         return true;
        //     s = s.substring(1);
        // }
        
        // return isMatch(s, p.substring(2));    
        
        //using DP
        /**
         * f[i][j]: if s[0..i-1] matches p[0..j-1]
         * if p[j - 1] != '*'
         *      f[i][j] = f[i - 1][j - 1] && s[i - 1] == p[j - 1]
         * if p[j - 1] == '*', denote p[j - 2] with x
         *      f[i][j] is true iff any of the following is true
         *      1) "x*" repeats 0 time and matches empty: f[i][j - 2]
         *      2) "x*" repeats >= 1 times and matches "x*x": s[i - 1] == x && f[i - 1][j]
         * '.' matches any single character
         */
        int ls = s.length();
        int lp = p.length();
        boolean[][] match = new boolean[ls+1][lp+1];
        match[0][0] = true;
        for(int i = 1; i <= ls; i++)
            match[i][0] = false;
        for(int i = 1; i <= lp; i++)
            match[0][i] = i>1 && p.charAt(i-1) == '*' && match[0][i-2];
            // p[0.., j - 3, j - 2, j - 1] matches empty iff p[j - 1] is '*' and p[0..j - 3] matches empty
            //[...]X* matches [...]
        for(int i = 1; i <= ls; i++){
            for(int j = 1; j <= lp; j++){
                if(p.charAt(j-1) != '*')
                    match[i][j] = match[i-1][j-1] && 
                                  (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');
                else // important and kind of hard to understand
                    match[i][j] = match[i][j-2] ||
                                  (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') &&
                                  match[i-1][j];
            }
        }
        return match[ls][lp];
    }
}
