import java.util.*;

public class Problem145_Binary_Tree_Postorder_Traversal {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        postorderTraversal(root, list);
        return list;
    }
    public void postorderTraversal(TreeNode root, List<Integer> list){
        
        if(root.left != null)
            postorderTraversal(root.left, list);
        if(root.right != null)
            postorderTraversal(root.right, list);
        list.add(root.val);
    }
}
