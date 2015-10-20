
public class Problem23_Merge_k_Sorted_Lists {
	public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if(size == 0)
            return null;
        if(size == 1)
            return lists[0];
        return mergeLists(lists, 0, lists.length-1);
    }
    
    public ListNode mergeLists(ListNode[] lists, int lo, int hi){
        if(lo < hi){
            int mid = (lo+hi)/2;
            ListNode l1 = mergeLists(lists, lo, mid);
            ListNode l2 = mergeLists(lists, mid+1, hi);
            return mergeLists(l1, l2);
        }
        return lists[lo];
    }
    
    public ListNode mergeLists(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 == null){
            while(l2 != null){
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        else if(l2 == null){
            while(l1 != null){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
        }
        return res.next;
    }
}
