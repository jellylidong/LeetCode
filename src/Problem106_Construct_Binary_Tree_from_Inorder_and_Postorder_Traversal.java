import java.util.*;
public class Problem106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        int lin = inorder.length;
        int lpo = postorder.length;
        if(lin != lpo || lin == 0)
            return null;
        
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < lin; i++)
            hash.put(inorder[i], i);
        
        return build(0, lin-1, inorder, 0, lpo-1,  postorder,  hash);

    }
    
    public TreeNode build(int inlo, int inhi, int[] inorder, int polo, int pohi, int[] postorder, HashMap<Integer, Integer> hash){
        
        if(inlo == inhi)
            return new TreeNode(inorder[inlo]);
        TreeNode root = new TreeNode(postorder[pohi]);
        int inId = hash.get(postorder[pohi]);
        int lefthi = inId-1;
        int rightlo = inId+1;
        if(lefthi >= inlo)
            root.left = build(inlo, lefthi, inorder, polo, pohi-(inhi-inId)-1,  postorder, hash);
        if(rightlo <= inhi)
            root.right = build(rightlo, inhi, inorder, pohi-(inhi-inId), pohi-1, postorder, hash);
        return root;
    }
	
	//this method exceed time limit, maybe use hash to find index can make it faster
	/*public TreeNode buildTree(int[] inorder, int[] postorder) {
        int l = inorder.length - 1;
        TreeNode root = new TreeNode(postorder[l]);
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        for(int i = l-1; i >= 0; i--){
            int postcur = indexOf(postorder[l], inorder);
            int postpre = indexOf(postorder[l+1], inorder);
            if(postcur < postpre){
                int j = l+1;
                while(postcur < postpre && j <= l){
                    j++;
                    postpre = indexOf(postorder[j], inorder);
                }
                TreeNode tmp = list.get(l-i-1);
                tmp.left =new TreeNode(postorder[i]);
                list.add(tmp.left);
            }
            else if(postcur > postpre){
                int j = l+1;
                while(postcur > postpre && j <= l){
                    j++;
                    postpre = indexOf(postorder[j], inorder);
                }
                TreeNode tmp = list.get(l-i-1);
                tmp.right =new TreeNode(postorder[i]);
                list.add(tmp.right);
            }
        }
        return root;
    }
    
    public int indexOf(int n, int[] nums){
        int i = 0;
        while(nums[i] != n)
            i++;
        return i;
    }*/
}
