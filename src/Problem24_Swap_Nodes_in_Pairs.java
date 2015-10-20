
public class Problem24_Swap_Nodes_in_Pairs {
	public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode cur1 = head;
        ListNode cur2 = head.next;
        cur1.next = cur2.next;
        cur2.next = cur1;
        head = cur2;
        ListNode cur0 = cur1;
        cur1 = cur1.next;
        while(cur1 != null){
            if(cur1.next == null)
                return head;
            cur2 = cur1.next;
            cur1.next = cur2.next;
            cur2.next = cur1;
            //head = cur2;
            cur0.next = cur2;
            cur0 = cur1;
            cur1 = cur1.next;
        }
        return head;
    }
}
