
public class Problem203_Remove_LinkedList_Elements {
	public ListNode removeElements(ListNode head, int val) {
        ListNode helper = new ListNode(0);
        helper.next = head;
        
        ListNode pre = helper;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                cur = pre.next;
            }
            else{
                pre = cur;
                cur = cur.next;
            }
        }
        return helper.next;
    }
}
