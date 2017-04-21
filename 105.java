public class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int index = preorder.length - 1;
    TreeNode root = build(preorder, 0, index, inorder, 0, index);
    return root;
  }

  private TreeNode build(int[] preorder, int i, int j, int[] inorder, int m, int n) {
    if(i >= preorder.length ||  m > n) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[i]);
    int numLeft = 0;
    for(int k = m; k <= n; k++) {
      if(preorder[i] == inorder[k]) {
        numLeft = k - m;
      }
    }
    root.left = build(preorder, i + 1, i + numLeft, inorder, m, m + numLeft - 1);
    root.right = build(preorder, i + numLeft + 1, j, inorder, m + numLeft + 1, n);
    return root; 
  }
}
