import java.util.*;

public class Problem131_Palindrome_Partitioning {
	List<List<String>> lists;
    List<String> list;
    public List<List<String>> partition(String s) {
        lists = new ArrayList<>();
        list = new ArrayList<>();
        backTrack(s, 0);
        return lists;
    }
    
    public void backTrack(String s, int start){
        if(list.size() > 0 && start == s.length()){ //what the list.size() >0 used for?
            List<String> tmp = new ArrayList<String>();//list.clone();
            tmp.addAll(list);
            lists.add(list);
        }
        
        for(int i = start; i < s.length(); i++){
            if(isP(s, start, i)){
                if(start == i)
                    list.add(Character.toString(s.charAt(i)));
                else
                    list.add(s.substring(start, i+1));
                backTrack(s, i+1);
                list.remove(list.size()-1);
            }
        }
        
    }
    
    public boolean isP(String s, int start, int end){
        if(start == end)
            return true;
        while(start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
