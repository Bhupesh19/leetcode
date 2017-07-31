public class Solution {
  public void connect(TreeLinkNode root) {
    if(root == null) return;
    TreeLinkNode start = root;
    while(start.left != null) {
      TreeLinkNode curr = start;
      while(curr != null) {
        if(curr.left != null) {
          curr.left.next = curr.right;
        }
        if(curr.right != null && curr.next != null) {
          curr.right.next = curr.next.left;
        }
        curr = curr.next;
      }
      start = start.left;
    }
  }
}
