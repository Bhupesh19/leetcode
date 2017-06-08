public class Solution {

  private int num = 0;
  private TreeNode kth = null;

  public int kthSmallest(TreeNode root, int k) {
    inorder(root, k);
    return kth.val;
  }

  private void inorder(TreeNode root, int k) {
    if(root == null) {
      return;
    }
    inorder(root.left, k);
    num++;
    if(num == k) {
      kth = root;
      return;
    }
    inorder(root.right, k);
  }
}
