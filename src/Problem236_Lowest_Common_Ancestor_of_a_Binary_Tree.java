
public class Problem236_Lowest_Common_Ancestor_of_a_Binary_Tree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null)
            return null;
        
        if(root == p)
            if(isSub(p, q))
                return p;
        if(root == q)
            if(isSub(q, p))
                return q;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if(left != null)
            return left;
        TreeNode right= lowestCommonAncestor(root.right, p, q);
        if(right != null)
            return right;
        if(isSub(root, p) && isSub(root,q)){
            if(p == q)
                return p;
            else
                return root;
        }
        return null;
        
    }
    
    public boolean isSub(TreeNode p, TreeNode q){
        if(p == null || q == null)
            return false;
        if(p.left != null){
             if(p.left == q)
                return true;
        }
        if(p.right != null){
            if(p.right == q)
                return true;
        }
        return isSub(p.left, q) || isSub(p.right, q);
    }
}
