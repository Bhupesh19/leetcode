public class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode newHead = new ListNode(0);
    newHead.next = head;
    ListNode p = newHead;
    for(int i = 0; i < m - 1; i++) {
      p = p.next;
    }
    ListNode q = p.next;
    for(int i = m; i <= n - 1; i++) {
      ListNode curr = q.next;
      ListNode prev = p.next;
      q.next = q.next.next;
      p.next = curr;
      curr.next = prev;
    }
    return newHead.next;
  }
}
