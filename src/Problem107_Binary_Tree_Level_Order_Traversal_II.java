import java.util.*;
public class Problem107_Binary_Tree_Level_Order_Traversal_II {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root == null)
            return lists;
        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        lists.add(list);
        Queue<tube> q = new LinkedList<tube>();
        q.add(new tube(root, 0));
        while(!q.isEmpty()){
            tube leaf = q.remove();
            TreeNode node = leaf.node;
            int level = leaf.level;
            if(lists.size() <= level){
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(node.val);
                lists.add(tmp);
            }
            else if(level != 0){
                lists.get(level).add(node.val);
            }
            if(node.left != null)
                q.add(new tube(node.left, level+1));
            if(node.right != null)
                q.add(new tube(node.right, level+1));
        }
        List<List<Integer>> newlists = new ArrayList<List<Integer>>();
        for(int i  = lists.size() - 1; i >= 0; i--){
            newlists.add(lists.get(i));
        }
        return newlists;
    }
    
    private class tube{
        int level;
        TreeNode node;
        tube(TreeNode root, int n){
            node = root;
            level = n;
        }
    }
}
