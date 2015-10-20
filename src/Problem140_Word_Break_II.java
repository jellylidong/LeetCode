import java.util.*;
public class Problem140_Word_Break_II {
//	exceed time limit
	//	public List<String> wordBreak(String s, Set<String> wordDict) {
//        List<String> res = new ArrayList<>();
//        if(s.length() == 0)
//            return res;
//        for(int i = 0; i <= s.length(); i++){
//            String ss = s.substring(0,i);
//            if(!wordDict.contains(ss))
//                continue;
//            StringBuilder sb = new StringBuilder();
//            sb.append(ss);
//            wordBreak(s.substring(i), wordDict, sb, res);
//        }
//        return res;
//    }
//    
//    public static void wordBreak(String s, Set<String> wordDict, StringBuilder sb, List<String> res){
//        if(s.length() == 0)
//            res.add(sb.toString());
//        for(int i = 0; i <= s.length(); i++){
//            String ss = s.substring(0, i);
//            if(!wordDict.contains(ss))
//                continue;
//            sb.append(" " + ss);
//            wordBreak(s.substring(i), wordDict, sb, res);
//            sb.delete(sb.length()-ss.length()-1, sb.length());
//        }
//    }
	
	
	//also TLE
//	public List<String> wordBreak(String s, Set<String> dict) {
//        Map<Integer, List<String>> map = new HashMap<>();
//        
//        //initial the map
//        List<String> l = new ArrayList<>();
//        l.add(""); //this step will be used to judge add " " or not
//        map.put(s.length(), l);
//        
//        for(int i=s.length()-1; i >= 0; i--){
//            List<String> res = new ArrayList<>();
//            for(int j = i+1; j <= s.length(); j++){// must be <=, or substring can not cover the last char
//                if(dict.contains(s.substring(i,j))){
//                    for(String w: map.get(j))
//                        res.add(s.substring(i,j) + (w.isEmpty()? "":" "));
//                }
//            }
//            map.put(i, res);
//        }
//        
//        return map.get(0);
//    }
	
HashMap<String, List<String>> map = new HashMap<>();
    
    public List<String> wordBreak(String s, Set<String> dict) {
        if(map.containsKey(s))
            return map.get(s);
        List<String> res = new ArrayList<>();
        if(dict.contains(s))
            res.add(s);
        for(int i = 1; i < s.length(); i++){
            String ls = s.substring(0, i);
            String rs = s.substring(i);
            if(dict.contains(ls) && containsSuffix(rs, dict)){
                for(String ss: wordBreak(rs, dict)
                    res.add(ls + " " + ss);
            }
        }
        map.put(s, res);
        return res;
    }
    
    public boolean containsSuffix(String s, Set<String> dict){
        for(int i = 0; i < s.length(); i++){
            if(dict.contains(s.substring(i)))
                return true;
        }
        return false;
    }
}
