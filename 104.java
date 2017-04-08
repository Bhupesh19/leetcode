public class Solution {
  public int maxDepth(TreeNode root) {
    if(root == null) {
      return 0;
    }
    if(root.left == null && root.right == null) {
      return 1;
    }
    int leftHeight = maxDepth(root.left) + 1;
    int rightHeight = maxDepth(root.right) + 1;
    return (leftHeight > rightHeight) ? leftHeight : rightHeight; 
  }
}
