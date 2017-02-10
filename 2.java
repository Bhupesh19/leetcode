public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode p = head;
    int c = 0;
    while(l1 != null || l2 != null || c != 0) {
      int sum = ((l1 == null) ? 0 : l1. val) + ((l2 == null) ? 0 : l2.val) + c;
      p.next = new ListNode(sum % 10);
      c = sum / 10;
      p = p.next;
      l1 = (l1 == null) ? l1 : l1.next;
      l2 = (l2 == null) ? l2 : l2.next;
    }
    return head.next;
  }
}
