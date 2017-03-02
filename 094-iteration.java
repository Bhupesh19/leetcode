public class Solution {
  
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> results = new ArrayList<>();
    Stack<TreeNode> nodes = new Stack<>();
    TreeNode curr = root;
    while(curr != null) {
      while(curr.left != null) {
        nodes.push(curr);
        curr = curr.left; 
      }
      results.add(curr.val);
      if(!nodes.isEmpty()) {
        curr = nodes.pop();
        results.add(curr.val);
        curr = curr.right;
        results.add(curr.val);
      } else {
        break;
      }
    } 
    return results; 
  }
}
