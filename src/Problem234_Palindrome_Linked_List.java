
public class Problem234_Palindrome_Linked_List {
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        else if(head.next.next == null)
            return head.val == head.next.val;
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next != null){//attention, when the length of list of even e.g [1,4], the slow will point at 2, not the mid, so this step is very import!
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        //pre = slow;
        ListNode cur = slow;
                 pre  = null;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        while(pre != null && head != null){
            if(pre.val != head.val)
                return false;
            pre = pre.next;
            head = head.next;
        }
        return true;
        
    }
}
