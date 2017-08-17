public class Solution {
  public TreeNode addOneRow(TreeNode root, int v, int d) {
    if(d == 1) {
      TreeNode newR = new TreeNode(v);
      newR.left = root;
      return newR;
    }
    add(root, v, d, 1);
    return root;
  }

  private void add(TreeNode root, int v, int d, int h) {
    if(d - h == 1) {
        TreeNode newl = new TreeNode(v);
        newl.left = root.left;
        root.left = newl;
        TreeNode newr = new TreeNode(v);
        newr.right = root.right;
        root.right = newr;
    }
    if(root.left != null) add(root.left, v, d, h + 1);
    if(root.right != null) add(root.right, v, d, h + 1);
  }
}
