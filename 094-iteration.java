public class Solution {
  
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> results = new ArrayList<>();
    Stack<TreeNode> nodes = new Stack<>();
    TreeNode curr = root;
    while(curr != null || !nodes.isEmpty()) {
      while(curr != null) {
        nodes.push(curr);
        curr = curr.left; 
      }
      curr = nodes.pop();
      results.add(curr.val);
      curr = curr.right;
    } 
    return results; 
  }
}
