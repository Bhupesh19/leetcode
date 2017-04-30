public class Solution {
  public boolean isBalanced(TreeNode root) {
    if(root == null) {
      return true;
    }
    return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left)-height(root.right)) <= 1; 
  }

  private int height(TreeNode root) {
    if(root == null) {
      return 0;
    }
    int leftHeight = height(root.left) + 1;
    int rightHeight = height(root.right) + 1;
    return (leftHeight > rightHeight) ? leftHeight : rightHeight;
  }
}
