
import java.util.*;
public class Problem57_Binary_Tree_Paths {
	static List<String> res = new ArrayList<>();
    public static List<String> binaryTreePaths(TreeNode root) {
        
        // List<String> res = new ArrayList<>();
        if(root == null)
            return res;
        String tmp = Integer.toString(root.val);
        path(root, tmp);
        return res;
    }
    
    public static void path(TreeNode root, String s){
        if(root.left != null){
            s += "->" + Integer.toString(root.left.val);
            path(root.left, s);
            // if(s.length() > 3)
            //     s = s.substring(0, s.length()-3);
            s = del(s);
        }
        if(root.right != null){
            // if(s.charAt(s.length()-1) == '-')
            //     s = s.substring(0, s.length()-1);
            s += "->" + Integer.toString(root.right.val);
            path(root.right, s);
            // if(s.length() > 3)
            //     s = s.substring(0, s.length()-3);
            s = del(s);
        }
        if(root.left == null && root.right == null)
            res.add(s);
            // if(s.length() > 3)
            //     s = s.substring(0, s.length()-3);
            s = del(s);
    }
    
    public static String del(String s){
        int l = s.length();
        int cut = 0;

        while(l-1 > cut && s.charAt(l-1-cut) != '>' )
            cut++;
        System.out.println(cut);
        if(l-1 > cut+1 && s.charAt(l-cut-2) == '-' ){
            System.out.println("done!");
        	cut++;
        }
        System.out.println(cut);
        return s.substring(0, l-cut-1); //if not -1, l-cut can only get number if -, e.g. 89-
    }
    
    public static void main(String[] args){
    	String s = "123->-234";
    	System.out.print(del(s));
    }
}
