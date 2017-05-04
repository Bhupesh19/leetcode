public class Solution {
  public TreeNode sortedListToBST(ListNode head) {
    if(head == null) {
      return null;
    }
    return sortList(head, null);
  }

  private TreeNode sortList(ListNode head, ListNode tail) {
    if(head == tail) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while(fast != tail && fast.next != tail) {
      slow = slow.next;
      fast = fast.next.next;
    }
    TreeNode root = new TreeNode(slow.val);
    root.left = sortList(head, slow);
    root.right = sortList(slow.next, tail);
    return root;
  }
}
