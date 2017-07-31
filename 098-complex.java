public class Solution {
  public boolean isValidBST(TreeNode root) {
    if(root == null) return true;
    return (root.val > findMax(root.left)) && (root.val < findMin(root.right)) && isValidBST(root.left) && isValidBST(root.right);
  }

  private long findMax(TreeNode root) {
    long max = Long.MIN_VALUE;
    while(root != null) {
      max = root.val;
      root = root.right;
    }
    return max;
  }
  
  private long findMin(TreeNode root) {
    long min = Long.MAX_VALUE;
    while(root != null) {
      min = root.val;
      root = root.left;
    }
    return min;
  }
}
