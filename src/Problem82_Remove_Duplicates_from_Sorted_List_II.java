
public class Problem82_Remove_Duplicates_from_Sorted_List_II {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode helper = new ListNode(0);
        helper.next = head;
         ListNode cur = head;
         ListNode pre = helper;
         
         while(cur != null){
             ListNode tmp = cur.next;
             int count = 1;
             while(tmp != null && cur.val == tmp.val){
                 count++;
                 tmp = tmp.next;
             }
             if(count == 1){
                pre.next = cur;
                pre = cur;
             }
             cur = tmp;
         }
         pre.next = null;
         return helper.next;
    }
}
