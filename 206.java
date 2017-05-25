public class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode p = head;
    ListNode q = null;
    while(p != null) {
      ListNode temp = new ListNode(p.val);
      temp.next = q;
      q = temp;
      p = p.next;
    }
    return q;
  }
}
