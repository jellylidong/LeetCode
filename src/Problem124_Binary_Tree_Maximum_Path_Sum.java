
public class Problem124_Binary_Tree_Maximum_Path_Sum {
	int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxDown(root);
        return max;
    }
    
    public int maxDown(TreeNode root){
        if(root == null)
            return 0;
        int left = Math.max(0, maxDown(root.left));
        int right= Math.max(0, maxDown(root.right));
        max = Math.max(max, root.val+left+right);
        return Math.max(left, right) + root.val;
        
    }
}
