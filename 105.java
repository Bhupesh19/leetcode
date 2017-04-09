public class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int index = preorder.length - 1;
    TreeNode root = build(preorder, 0, index, inorder, 0, index);
    return root;
  }

  private TreeNode build(int[] preorder, int i, int j, int[] inorder, int m, int n) {
    if(i > j) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[i]);
    int leftLast = 0;
    for(int in = m; in <= n; in++) {
      if(inorder[in] == root.val) {
        leftLast = in - 1;
      }
    }
    root.left = build(preorder, i+1, leftLast-m+i+2, inorder, m, leftLast);
    root.right = build(preorder, leftLast-m+i+3, j, inorder, leftLast+1, n);
    return root; 
  }
}
