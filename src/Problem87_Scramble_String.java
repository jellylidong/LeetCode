import java.util.*;
public class Problem87_Scramble_String {
	public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 != l2)
            return false;
        HashSet<Character> hash = new HashSet<>();
        for(int i = 0 ; i < l1; i++){
            if(hash.contains(s1.charAt(i)))
                hash.remove(s1.charAt(i));
            else
                hash.add(s1.charAt(i));
            if(hash.contains(s2.charAt(i)))
                hash.remove(s2.charAt(i));
            else
                hash.add(s2.charAt(i));
        }
        if(hash.size() != 0)
            return false;
        for(int i = 1; i < l1; i++){
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, l1);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, l1);
            String s23 = s2.substring(l1-i);
            String s24 = s2.substring(0,l1-i);
            boolean res = (isScramble(s11, s21) && isScramble(s12, s22)) || 
                          (isScramble(s11, s22) && isScramble(s12, s21)) ||
                          (isScramble(s11, s23) && isScramble(s12, s24)) ||
                          (isScramble(s11, s24) && isScramble(s12, s23));
            if(res)
                return res;
        }
        return false;
    }
}
