
public class Problem142_Linked_List_Cycle_II {
	public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
                if(slow == fast)
                    break;
            }
            else
                return null;
        }
        if(fast == null)
            return null;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
