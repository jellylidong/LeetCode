
public class Problem116_Populating_Next_Right_Pointers {
	public void connect(TreeLinkNode root) {
        if(root != null){
            //root.next = null;
            //TreeLinkNode root = root;
            if(root.left != null){
                root.left.next = root.right;
            }
            if(root.right != null){
                if(root.next != null)
                {root.right.next = root.next.left;}
            }
            connect(root.left);
            connect(root.right);
        }
    }
}
