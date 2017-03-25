public class Solution {
  public ListNode partition(ListNode head, int x) {
    ListNode newHead = new ListNode(0);
    newHead.next = head;
    ListNode p = newHead;
    ListNode q = head;
    while(q != null && q.val < x) {
      p = p.next;
      q = q.next;
    }
    while(q != null && q.next != null) {
      if(q.next.val < x) {
        ListNode temp1 = q.next.next;
        ListNode temp2 = p.next;
        p.next = q.next;
        p.next.next = temp2;
        q.next = temp1;
        p = p.next;
      } else {
        q = q.next;
      }
    }
    return newHead.next;
  }
}
