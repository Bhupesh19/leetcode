public class Solution {
  
  private int max = Integer.MIN_VALUE;
  
  public int maxPathSum(TreeNode root) {
    int pm = pathSum(root);
    return (max > pm) ? max : pm;
  }

  private int pathSum(TreeNode root) {
    if(root == null) {
      return 0;
    }
    int l = pathSum(root.left);
    l = (l < 0) ? 0 : l;
    int r = pathSum(root.right);
    r = (r < 0) ? 0 : r;
    max = (max > l + r + root.val) ? max : l + r + root.val;
    return (l > r) ? l + root.val : r + root.val;
  }
}
