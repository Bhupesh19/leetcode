public class Solution {
  public void connect(TreeLinkNode root) {
    if(root == null) return;
    Queue<TreeLinkNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()) {
      TreeLinkNode curr = new TreeLinkNode(0); 
      int num = queue.size();
      for(int i = 0; i < num; i++) {
        curr = queue.poll();
        if(i != num - 1) {
          curr.next = queue.peek();
        }
        if(curr.left != null) queue.offer(curr.left);
        if(curr.right != null) queue.offer(curr.right);
      }
    }
  }
}
