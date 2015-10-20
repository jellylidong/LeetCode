/*current solution is too slow !!!*/
import java.util.*;
public class Problem22_Generate_Parentheses {
	public static List<String> generateParenthesis(int n) {
		//System.out.println(n);
		if(n == 0)
            return null;
        List<List<String>> lists = new ArrayList<List<String>>();
        List<String> head = new ArrayList<String>();
        head.add("");
        lists.add(head);
        
             
        for(int i = 1; i <= n; i++){
        	//System.out.println(i);
            //HashSet<String> hash = new HashSet<String>();
            List<String> cur = new ArrayList<String>();
            for(String node: head){
            	//System.out.println("node length:" + node.length());
                for(int j = 0; j <= node.length(); j++){
                    String str = insert(j, node);
                    //System.out.println(str);
                    if(!cur.contains(str)){
                        //hash.add(str);
                        cur.add(str);
                    }
                }
            }
            lists.add(cur);
            head = lists.get(i);
        }
        return head;
    }
    
    private static String insert(int i, String str){
        if(i == 0)
            return "()" + str;
        if(i == str.length())
            return str + "()";
        return str.substring(0, i) + "()" + str.substring(i, str.length());
    }
    
    public static void main(String[] arg){
    	System.out.println("aaa");
    	List<String> head = generateParenthesis(4);
    	tools.printList(head);
    }
}
