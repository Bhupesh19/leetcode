public class Solution {
  public int minDepth(TreeNode root) {
    if(root == null) {
      return 0;
    }
    int leftDepth = minDepth(root.left);
    int rightDepth = minDepth(root.right);
    if(leftDepth == 0 || rightDepth == 0) {
      return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    }
    return (leftDepth < rightDepth) ? leftDepth + 1 : rightDepth + 1; 
  }
}
