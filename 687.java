class Solution {
  public int longestUnivaluePath(TreeNode root) {
    if(root == null) return 0;
    int max = findPath(root.left, root.val) + findPath(root.right, root.val); 
    int maxLeft = longestUnivaluePath(root.left);
    int maxRight = longestUnivaluePath(root.right);
    return Math.max(maxLeft, Math.max(maxRight, max)); 
  }

  public int findPath(TreeNode root, int last) {
    if(root == null) return 0;
    if(root.val == last) {
      return Math.max(1 + findPath(root.left, root.val), 1 + findPath(root.right, root.val));
    } else {
      return 0;
    }
  }
}
