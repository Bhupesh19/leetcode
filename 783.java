class Solution {
  private int minDis = Integer.MAX_VALUE;
  private int max = Integer.MIN_VALUE;
  
  public int minDiffInBST(TreeNode root) {
    inorder(root);
    return minDis;
  }
    
  private void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    if (max != Integer.MIN_VALUE) {
      minDis = Math.min(Math.abs(max - root.val), minDis);
    }
    max = root.val;
    inorder(root.right);
  }
}
