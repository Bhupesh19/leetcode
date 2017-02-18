public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    int len = 0;
    for(ListNode p = head; p != null; p = p.next) {
      len++;
    }
    if(head == null || n > len) {
      return null;
    } 
    if(len - n == 0) {
      return head.next;
    }
    ListNode p = head;
    for(int i = 1; i < len-n; i++) {
      p = p.next;
    }
    p.next = p.next.next;
    return head;
  }
}
