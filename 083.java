public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    if(head == null) {
      return head;
    } 
    ListNode p = head;
    ListNode q = p.next;
    while(true) {
      while(q != null && p.val == q.val) {
        q = q.next;
      }
      p.next = q;
      p = q;
      if(q != null) {
        q = q.next;
      } else {
        break;
      }
    } 
    return head; 
  }
}
