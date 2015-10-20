import java.util.*;
public class Problem150_Evaluate_Reverse_Polish_Notation {
	public int evalRPN(String[] tokens) {
        //boolean hasValue1 = false, hasValue2 = false;
        int v1 = 0, v2 = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/"))
                stack.push(Integer.parseInt(tokens[i]));
            else{
                v2 = stack.pop();
                v1 = stack.pop();
                int res = 0;
                switch(tokens[i]){
                    case "+":   res = v1+v2;    break;
                    case "-":   res = v1-v2;    break;
                    case "*":   res = v1*v2;    break;
                    case "/":   res = v1/v2;    break;
                    default:    break;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }
}
