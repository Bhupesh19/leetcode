public class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if(head == null || head.next == null) {
      return head;
    }
    int len = 1;
    ListNode p = head;
    for(; p.next != null; p = p.next) {
      len++; 
    }
    ListNode tail = p;
    p.next = head;
    int offset = len - (k % len);
    for(int i = 0; i < offset; i++) {
      head = head.next;
      tail = tail.next;
    }
    tail.next = null;
    return head;
  }
}
