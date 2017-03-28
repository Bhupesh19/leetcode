public class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode newHead = new ListNode(0);
    newHead.next = head; 
    ListNode p = newHead;
    ListNode q = head;  
    for(int i = 0; i <= n; i++) {
      if(i < m - 1) {
        p = p.next;
        q = q.next;
      } else {
        ListNode temp = q.next;
        q.next = q.next.next;
        temp.next = p.next;
        p.next = temp;
      }
    } 
    return newHead.next; 
  }
}
