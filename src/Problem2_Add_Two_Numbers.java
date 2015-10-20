
public class Problem2_Add_Two_Numbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(l1 != null && l2 != null){
            sum = (carry + l1.val + l2.val)%10;
            carry = (carry + l1.val + l2.val)/10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null ){
            while(l2 != null){
                sum = (carry + l2.val)%10;
                carry= (carry + l2.val)/10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                l2 = l2.next;
            }
        }
        else if(l2 == null){
            while(l1 != null){
                sum = (carry + l1.val)%10;
                carry= (carry + l1.val)/10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                l1 = l1.next; 
            }
        }
        if(carry != 0)
            cur.next = new ListNode(carry);
        return res.next;
    }
}
