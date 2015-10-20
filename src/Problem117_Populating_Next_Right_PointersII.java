
public class Problem117_Populating_Next_Right_PointersII {
	public void connect(TreeLinkNode root) {
        if(root != null){
            //root.next = null;
            TreeLinkNode parent = root;
            if(parent.left != null){
                TreeLinkNode tmp = parent.right;
                if(tmp == null){
                    while(parent.next != null && parent.left == null && parent.right == null){
                        parent = parent.next;
                    }
                    if(parent != null){                        
	                    if(parent.left != null)
	                        tmp = parent.left;
	                    else if(parent.right != null){
	                        tmp = parent.right;
	                    }
                    }
                }
                root.left.next = tmp;
            }
            if(root.right != null){
                TreeLinkNode tmp = parent.right;
                if(tmp == null){
                    while(parent.next != null && parent.left == null && parent.right == null){
                        parent = parent.next;
                    }
                    if(parent != null){                        
	                    if(parent.left != null)
	                        tmp = parent.left;
	                    else if(parent.right != null){
	                        tmp = parent.right;
	                    }
                    }
                }
                root.right.next = tmp;
            }
            connect(root.left);
            connect(root.right);
        }
    }
}
