
public class Problem110_Balanced_Binary_Tree {
	public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        /*if(root.left != null && root.right == null){
            if(root.left.left != null || root.left.right != null)
                return false;
            else return true;
        }
        if(root.right != null && root.left == null){
            if(root.right.left != null || root.right.right != null)
                return false;
            else return true;
        }
        return isBalanced(root.left) && isBalanced(root.right);*/
        table left = height(root.left, 1);
        table right = height(root.right, 1);
        return left.balance && right.balance && Math.abs(left.height - right.height) <= 1;
    }
    
    private class table{
        boolean balance;
        int height;
        table(boolean x, int y){
            balance = x;
            height = y;
        }
    }
    
    private table height(TreeNode root, int level){
        if(root == null)
            return new table(true, level);
        table left = height(root.left, level + 1);
        table right = height(root.right, level + 1);
        if(!left.balance || !right.balance)
            return new table(false, level);
        return new table(left.balance && right.balance && Math.abs(left.height - right.height) <= 1,
                    Math.max(left.height, right.height));
    }
}
