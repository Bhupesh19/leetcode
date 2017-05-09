public class Solution {
  public int sumNumbers(TreeNode root) {
    return sum(root, 0); 
  }

  private int sum(TreeNode root, int curr) {
    if(root == null) {
      return 0;
    }
    if(root.left == null && root.right == null) {
      return 10 * curr + root.val;
    }
    return sum(root.left, 10 * curr + root.val) + sum(root.right, 10 * curr + root.val);
  }
}
