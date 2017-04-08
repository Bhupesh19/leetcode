public class Solution {
  public boolean isSymmetric(TreeNode root) {
    return isSymmetricTrees(root, root); 
  }
  
  private boolean isSymmetricTrees(TreeNode first, TreeNode second) {
    if(first == null && second == null) {
      return true;
    }
    if(first == null || second == null) {
      return false;
    }
    return first.val == second.val && isSymmetricTrees(first.right, second.left) && isSymmetricTrees(first.left, second.right);
  }
}
