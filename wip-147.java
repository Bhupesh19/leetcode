public class Solution {
  public ListNode insertionListNode(ListNode head) {
    ListNode sent = new ListNode(0);
    sent.next = head;
    ListNode curr = head;
    ListNode prev = sent;
    while(curr != null) {
      prev = sent;
      while(prev.next != curr && prev.next.val <= curr.val) {
        prev = prev.next;
      }
      ListNode next = curr.next;
      if(prev.next != curr) {
        curr.next = prev.next;
        prev.next = curr;
        curr = next;
      }
    }
  }
}
