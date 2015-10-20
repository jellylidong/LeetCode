
public class Problem112_Path_Sum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        return SUM(root, 0, sum);
    }
    
    private boolean SUM(TreeNode root, int sum, int target){
        boolean left = false;
        boolean right = false;
        int newsum = root.val + sum;
        if(root.left != null)
            left = SUM(root.left, newsum, target);
        if(root.right != null)
            right = SUM(root.right, newsum, target);
        if(root.left == null && root.right == null)
            if(newsum == target)
                return true;
        return left || right;
        
    }
}
