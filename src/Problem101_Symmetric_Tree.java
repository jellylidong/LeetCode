import java.util.*;
public class Problem101_Symmetric_Tree {
	public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        List<leaf> list = new ArrayList<leaf>();
        dfs(root, list, 3);
        int size = list.size();
        if(size%2 == 0)
            return false;
        for(int i = 0; i < size/2; i++){
            if(list.get(i).node.val != list.get(size-1-i).node.val
                || list.get(i).dir == list.get(size-1-i).dir)
                return false;
        }
        return true;
    }
    
    private void dfs( TreeNode root, List<leaf> list, int dir){
        if(root.left != null)
            dfs(root.left, list, 0);
            
        list.add(new leaf(root, dir));
        
        if(root.right != null){
            dfs(root.right, list, 1);
        }
        
    }
    
    private class leaf{
        TreeNode node;
        int dir;
        leaf(TreeNode x, int y){
            node = x;
            dir = y;
        }
    }
}
