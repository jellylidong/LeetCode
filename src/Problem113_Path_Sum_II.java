import java.util.*;

public class Problem113_Path_Sum_II {
	public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root == null)
            return lists;
        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        
        /*if((root.left == null || root.right != null) && root.val == target)
                lists.add(list);
         if((root.left != null || root.right == null) && root.val == target)
                lists.add(list);*/
                
        int sum = 0+root.val;
        pathSum(root, sum, target, list, lists);
        return lists;
    }
    
    public void pathSum(TreeNode root, int sum, int target, List<Integer> list, List<List<Integer>> lists) {
        if(root.left != null){
            int newsum = sum + root.left.val;
            List<Integer> newlist = new ArrayList<Integer>(list);
            newlist.add(root.left.val);
            pathSum(root.left, newsum, target, newlist, lists);
        }
        if(root.right != null){
            int newsum = sum + root.right.val;
            List<Integer> newlist = new ArrayList<Integer>(list);
            newlist.add(root.right.val);
            pathSum(root.right, newsum, target, newlist, lists);
        }
        
       if((root.left == null && root.right == null) && sum == target)
            lists.add(list);
    }
}

/*Instead of copy the whole list for the next dfs, deleting the last node added after find result 
 * saves more time*/
