import java.util.*;
public class Problem92_Reverse_Linked_List_II {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        Stack<ListNode> s = new Stack<>();
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode cur = head;
        ListNode pre = helper;
        int counter = 1;
        int begin = Math.min(m, n);
        int end =Math.max(m, n);
        while(counter <= end){
            if(counter >= begin){
                s.push(cur);
                pre.next = cur.next;
            }
            else{
                pre = cur;
            }
            cur = cur.next;
            counter++;
        }
        while(!s.isEmpty()){
            ListNode tmp = s.pop();
            tmp.next = pre.next;
            pre.next = tmp;
            pre = pre.next;
        }
        return helper.next;
    }
}
