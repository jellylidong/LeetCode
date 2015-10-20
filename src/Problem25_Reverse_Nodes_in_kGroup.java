import java.util.Stack;

public class Problem25_Reverse_Nodes_in_kGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> s = new Stack<>();
        int count = 0;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode cur = head;
        ListNode pre = helper;
        while(cur != null){
            s.push(cur);
            count++;
            cur = cur.next;
            if(count == k){
                while(!s.empty()){
                    ListNode tmp = s.pop();
                    pre.next = tmp;
                    pre = tmp;
                }
                count = 0;
            }
        }
        Stack<ListNode> s2 = new Stack<>();
        while(!s.empty()){
            s2.push(s.pop());
        }
        while(!s2.empty()){
            ListNode tmp = s2.pop();
            pre.next = tmp;
            pre = tmp;
        }
        pre.next = null;
        return helper.next;
    }
}
