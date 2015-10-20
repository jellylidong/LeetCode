import java.util.*;
public class Problem102_Binary_Tree_Level_Order_Traversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root == null)
            return lists;
        trans(root, lists, 0);
        return lists;
    }
    
    private void trans(TreeNode root, List<List<Integer>> lists, int level){
        
        if(level < lists.size())
            lists.get(level).add(root.val);
        
        else{
            List<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            lists.add(list);
        }
        if(root.left != null)
            trans(root.left, lists, level+1);
        if(root.right != null)
            trans(root.right, lists, level+1);
    }
}
