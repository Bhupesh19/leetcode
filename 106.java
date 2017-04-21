public class Solution {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    int index = inorder.length - 1;
    return tree(inorder, 0, index, postorder, 0, index);
  }

  private TreeNode tree(int[] inorder, int m, int n, int[] postorder, int i, int j) {
    if(m > n || i < 0) {
      return null; 
    }
    TreeNode root = new TreeNode(postorder[j]);
    int numLeft = 0;
    for(int k = m; k <= n; k++) {
      if(inorder[k] == postorder[j]) {
        numLeft = k - m; 
      }
    }
    root.left = tree(inorder, m, m + numLeft - 1, postorder, i, i + numLeft - 1);
    root.right = tree(inorder, m + numLeft + 1, n, postorder, i + numLeft, j - 1);
    return root;
  }
}
