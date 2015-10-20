import java.util.*;
public class Problem129_Sum_Root_to_Leaf_Numbers {
	public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        int sum = 0;
        List<String> list = trans(root);
        for(String str: list)
            sum += Integer.parseInt(str);
        return sum;
    }
    
    public List<String> trans(TreeNode root){
        List<String> list = new ArrayList<String>();
        String rootStr = Integer.toString(root.val);
        if(root.left != null){
            List<String> tmp = trans(root.left);
            for(String str: tmp)
                list.add(rootStr+str);
        }
        if(root.right != null){
            List<String> tmp = trans(root.right);
            for(String str: tmp)
                list.add(rootStr+str);
        }
        if(root.left == null && root.right == null)
            list.add(rootStr);
        return list;
    }
}
