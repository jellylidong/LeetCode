import java.util.*;
public class Problem199_Binary_Tree_Right_Side_View {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        Queue<tube> q = new LinkedList<tube>();
        q.add(new tube(1, root));
        while(!q.isEmpty()){
            tube tmp = q.poll();
            if(tmp.level > list.size())
                list.add(tmp.node.val);
            else
                list.set(tmp.level-1, tmp.node.val);
            if(tmp.node.left != null)
                q.add(new tube(tmp.level+1, tmp.node.left));
            if(tmp.node.right != null)
                q.add(new tube(tmp.level+1, tmp.node.right));
        }
        return list;
    }
    
    private class tube{
        int level;
        TreeNode node;
        tube(int l, TreeNode n){
            level = l;
            node = n;
        }
    }
}
/*An optimizition is we can first add the right sub tree to  this list, and when next treenode with same order comes,
 we just ignore it, i.e only add treenode one time
 */