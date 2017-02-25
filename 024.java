public class Solution {
  public ListNode swapPairs(ListNode head) {
    if(head == null || head.next == null) {
      return head;
    }
    ListNode p = new ListNode(0);
    p.next = head;
    head = head.next;
    ListNode q = p.next;
    while(p.next != null && p.next.next != null) {
      ListNode temp = p.next;
      p.next = p.next.next;
      q = p.next.next;
      p.next.next = temp;
      temp.next = q;
      p = temp;
    }
    return head; 
  } 
}
