import java.util.Stack;
import java.util.Set;
public class Problem139_Word_Break {
	//This method works fine, but may exceed time limit for the worst cases
	/*public boolean wordBreak(String s, Set<String> wordDict) {
        int l = s.length();
        if(l == 0)  return false;
        Stack<point> stack = new Stack<>();
        
        //point p = new point(0, 0);
        //stack.put(start);
        int start = 0;
        for(int i = 1; i <= l && start < l; i++){
            String sub = s.substring(start, i);
            if(wordDict.contains(sub)){
                if(i == l)
                    return true;
                stack.push(new point(start, i));
                start = i;
            }
            else if(i == l){
                if(!stack.empty()){
                    point tmp = stack.pop();
                    start = tmp.start;
                    i = tmp.end;
                }
                else return false;
            }
        }
        return wordDict.contains(s);
    }
    
    public class point{
        int start;
        int end;
        point(int s, int e){
            start = s;
            end   = e;
        }
    }*/
	
	public boolean wordBreak(String s, Set<String> wordDict) {
        //the array breakable[i] stores whether the substring s.substring(0,i) is breakable or not
        //breakable[i+1] |= breakable[j]&&dict.contains(s.substring(j,i+1)), j>=0 && j<i+1
        boolean[] breakable = new boolean[s.length()+1];
        breakable[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                breakable[i] = breakable[j] && wordDict.contains(s.substring(j, i));
                if(breakable[i])
                    break;
            }
        }
        return breakable[s.length()];
    }
}
