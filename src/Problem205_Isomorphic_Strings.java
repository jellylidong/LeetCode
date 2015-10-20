import java.util.*;
public class Problem205_Isomorphic_Strings {
	 public boolean isIsomorphic(String s, String t) {
	        int l1 = s.length();
	        int l2 = t.length();
	        if(l1 != l2)
	            return false;
	        HashMap<Character, Integer> hs = new HashMap<>();
	        HashMap<Character, Integer> ht = new HashMap<>();
	        for(int i = 0; i < l1; i++){
	            if(!hs.containsKey(s.charAt(i)) && !ht.containsKey(t.charAt(i))){
	                hs.put(s.charAt(i), i);
	                ht.put(t.charAt(i), i);
	            }
	            else if(hs.containsKey(s.charAt(i)) && ht.containsKey(t.charAt(i))){
	                int ss = hs.get(s.charAt(i));
	                int tt = ht.get(t.charAt(i));
	                if(ss != tt)
	                    return false;
	            }
	            else
	                return false;
	        }
	        return true;
	    }
}
