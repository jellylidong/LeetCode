import java.util.*;
public class Problem32_Longest_Valid_Parentheses {
	public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')' && !stack.empty() && s.charAt(stack.peek())== '(')
                stack.pop();
            else
                stack.push(i);
        }
        // a more run time efficient way is to compute the max length while push and pop;
        // then the code below is not needed
        
        if(stack.empty())
            return s.length();
        else{
            int max = Integer.MIN_VALUE;
            int a = 0, b = s.length();
            while(!stack.empty()){
                a = stack.pop();
                max = Math.max(max, b-a-1); 
                b = a;
            }
            max = Math.max(max, b);
            res = max;
        }
        return res;
    }
}
