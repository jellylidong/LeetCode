import java.util.*;
public class Problem49_Group_Anagrams {
	//this code works fine, but exceed the time limit
	/*public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        //List<String> list = new ArrayList<>();
        for(String s: strs){
            boolean flag = true;
            for(List<String> l:lists){
                if(isAnagram(l.get(0), s)){
                    flag = false;
                    l.add(s);
                    break;
                }
            }
            if(flag){
                List<String> list = new ArrayList<>();
                list.add(s);
                lists.add(list);
            }
        }
        return lists;
    }
    
    public static boolean isAnagram(String base, String newStr){
        if(base.length() != newStr.length())
            return false;
        HashSet<Character> hash = new HashSet<>();
        for(int i = 0; i < base.length(); i++){
            if(hash.contains(base.charAt(i)))
                hash.remove(base.charAt(i));
            else hash.add(base.charAt(i));
            
            if(hash.contains(newStr.charAt(i)))
                hash.remove(newStr.charAt(i));
            else hash.add(newStr.charAt(i));
        }
        return hash.size() == 0;
    }*/
    
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        HashMap<String, Integer> hash = new HashMap<>();
        int id = 0;
        Arrays.sort(strs);
        for(int i = 0; i < strs.length; i++){
            String tmp = sort(strs[i]);
            if(!hash.containsKey(tmp)){
                hash.put(tmp, id);
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                lists.add(list);
                id++;
            }
            else{
                List<String> list = lists.get(hash.get(tmp));
                list.add(strs[i]);
            }
        }
        return lists;
    }
    
    public String sort(String str){
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
    
}
