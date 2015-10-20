import java.util.*;


public class Problem20_Valid_Parentheses {
	public boolean isValid(String s) {
        int l = s.length();
        if(l == 0)
            return true;
        if(l%2 == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int count = 1;
        while(count < l){
            if(!stack.empty()){
                char tmp = stack.pop();
                if((tmp == '(' && s.charAt(count) != ')') || (tmp == '[' && s.charAt(count) != ']') || (tmp == '{' && s.charAt(count) != '}')){
                    stack.push(tmp);
                    stack.push(s.charAt(count));
                }
            }
            else
                stack.push(s.charAt(count));
            count++;
        }
        
        return stack.empty();
    }
}
