public class Solution {
  
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> results = new ArrayList<>();
    inorder(results, root);
    return results; 
  }
  
  private void inorder(List<Integer> results, TreeNode root) {
    if(root == null) {
      return;
    }
    inorder(results, root.left);
    results.add(root.val);
    inorder(results, root.right);
  }
}
