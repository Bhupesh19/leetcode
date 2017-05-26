public class Solution {
  public ListNode removeElements(ListNode head, int val) {
    if(head == null) {
      return null;
    }
    while(head != null && head.val == val) {
      head = head.next;
    }
    ListNode p = head;
    while(p != null) {
      if(p.next != null && p.next.val == val) {
        p.next = p.next.next;
      } else {
        p = p.next;
      }
    }
    return head;
  }
}
