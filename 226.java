public class Solution {
  public TreeNode invertTree(TreeNode root) {
    if(root == null) {
      return null;
    }
    TreeNode r = invertTree(root.left);
    TreeNode l = invertTree(root.right);
    root.left = l;
    root.right = r;
    return root;
  }
}
