
public class Problem148_Sort_list {
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode slow=head, fast=head, pre=head;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null; //must be done so that the first part of the list end with null
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }
            else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if(l1 == null){
            while(l2 != null){
                pre.next = l2;
                l2 = l2.next;
                pre = pre.next;
            }
        }
        else{
            while(l1 != null){
                pre.next = l1;
                l1 = l1.next;
                pre = pre.next;
            }
        }
        //pre.next = null;
        return helper.next;
    }
}
