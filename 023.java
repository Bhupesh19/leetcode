public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    return partition(lists, 0, lists.length-1);  
  }
 
  private ListNode partition(ListNode[] lists, int l, int h) {
    if(l == h) {
      return lists[l];
    }
    if(l < h) {
      int q = (l + h) / 2;
      ListNode l1 = partition(lists, l, q);
      ListNode l2 = partition(lists, q+1, h);
      return mergeTwoLists(l1, l2); 
    } else {
      return null; 
    }
  }

  private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null) {
      return l2;
    }
    if(l2 == null) {
      return l1;
    }
    if(l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }
}
