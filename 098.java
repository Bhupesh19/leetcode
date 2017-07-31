public class Solution {
  public boolean isValidBST(TreeNode root) {
    return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE); 
  }

  private boolean isValid(TreeNode root, long min, long max) {
    if(root == null) return true;
    return isValid(root.left, min, root.val) && isValid(root.right, root.val, max) && root.val > min && root.val < max;
  }
}
