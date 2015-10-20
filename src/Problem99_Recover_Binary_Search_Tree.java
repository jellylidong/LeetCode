
public class Problem99_Recover_Binary_Search_Tree {
	TreeNode t1 = null;
    TreeNode t2 = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        
        inorder(root);
        if(t1 != null){
            int tmp = t1.val;
            t1.val = t2.val;
            t2.val = tmp;
        }
    }
    
    public void inorder(TreeNode root){
        if(root != null){
            
            inorder(root.left);
            if(root.val < pre.val){
                if(t1 == null)
                    t1 = pre;
                if(t1 != null)
                    t2 = root;
            }
            pre = root;
            inorder(root.right);
            
        }
    }
}
