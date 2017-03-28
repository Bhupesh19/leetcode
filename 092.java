public class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode newHead = new ListNode(0);
    newHead.next = head; 
    ListNode p = newHead;
    ListNode q = newHead;  
    int i = 0;
    return newHead.next; 
  }
}
