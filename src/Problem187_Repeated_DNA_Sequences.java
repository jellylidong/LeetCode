import java.util.*;
public  class Problem187_Repeated_DNA_Sequences {
	public static List<String> findRepeatedDnaSequences(String s) {
        HashSet<Integer> hash = new HashSet<>();
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i+10 <= s.length(); i++){
            String sub = s.substring(i, i+10);
            int subb = toHash(sub);
            if(!hash.contains(subb))
                hash.add(subb);
            else{
                
                if(!list.contains(sub))
                    list.add(sub);
            }
        }
        return list;
    }
    
    public static int toHash(String s){
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
        	res = res<<3;
            res = res + (c&7);
            
        }
        return res;
    }
	
	public static void main(String[] args){
		List<String> list = new ArrayList<>();
		list = findRepeatedDnaSequences("AAAAAAAAAAA");
		tools.printList(list);
	}
	
}
