import java.util.*;
public class Problem230_Kth_Smallest_Element_in_a_BST {
	public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        trans(root, list);
        return list.get(k-1).val;
    }
    
    private void trans(TreeNode root, List<TreeNode> list){
        if(root.left != null)
            trans(root.left, list);
        list.add(root);
        if(root.right != null)
            trans(root.right, list);
    }
}
