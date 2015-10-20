import java.util.*;
public class Problem86_Partition_List {
	public ListNode partition(ListNode head, int x) {
        if(head == null)
            return head;
        ListNode curhead = head;
        ListNode curnode = head;
        List<ListNode> small = new ArrayList<ListNode>();
        List<ListNode> big   = new ArrayList<ListNode>();
        while(curnode != null){
            if(curnode.val < x)
                small.add(curnode);
            else
                big.add(curnode);
            curnode = curnode.next;
        }
        small.addAll(big);
        curnode = small.get(0);
        curhead = curnode;
        for(int i = 1; i < small.size(); i++){
            curnode.next = small.get(i);
            curnode = curnode.next;
        }
        curnode.next = null;
        return curhead;
    }
}

/*a better way is to use two Lists of ListNode to store the small ones and big ones, 
 * then connect the tow lists directly*/
 