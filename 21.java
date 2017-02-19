public class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode sentinel = new ListNode(0);
    ListNode p = sentinel;
    while(l1 != null || l2 != null) {
      if(l1 == null) {
        while(l2 != null) {
          p.next = l2;
          p = p.next;
          l2 = l2.next;
        }
      } else if(l2 == null) {
        while(l1 != null) {
          p.next = l1;
          p = p.next;
          l1 = l1.next;
        }
      } else {
        if(l1.val > l2.val) {
          p.next = l2;
          p = p.next;
          l2 = l2.next;
        } else {
          p.next = l1;
          p = p.next;
          l1 = l1.next;
        }
      } 
    }
    return sentinel.next;
  }
}
