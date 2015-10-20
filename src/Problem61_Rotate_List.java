
public class Problem61_Rotate_List {
	public ListNode rotateRight(ListNode head, int k) {
	       if(k == 0 || head == null || head.next == null)
	        return head;
	       int size = 0;
	       ListNode cur = head;
	       ListNode pre = head;
	       while(cur != null){
	            size++;
	            cur = cur.next;
	       }
	       k = k%size;
	       if(size - k == 0)
	            return head;
	       cur = head;
	       pre = null;
	       int i = size-k;
	       ListNode newhead = null;
	       
	       while(i >0){
	           i--;
	           pre = cur;
	           cur = cur.next;
	       }
	       if(cur == null)
	        return head;
	       pre.next = null;
	       newhead = cur;
	       while(cur.next != null)
	            cur = cur.next;
	       cur.next = head;
	       
	       return newhead;
	    }
}
