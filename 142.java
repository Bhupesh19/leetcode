public class Solution {
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    boolean isExist = false;
    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast) {
        isExist = true;
        break;
      }
    }
    if(!isExist) {
      return null;
    }
    slow = head;
    while(slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}
