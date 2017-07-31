public class Solution {
  public void connect(TreeLinkNode root) {
    if(root == null) return;
    TreeLinkNode prev = root;
    while(prev != null) {
      TreeLinkNode p = new TreeLinkNode(0);
      TreeLinkNode head = p;
      while(prev != null) {
        if(prev.left != null) {
          p.next = prev.left;
          p = p.next;
        }
        if(prev.right != null) {
          p.next = prev.right;
          p = p.next;
        }
        prev = prev.next;
      }
      prev = head.next;
    }
  }
}
