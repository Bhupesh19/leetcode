public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> pt = new ArrayList<>();
    List<TreeNode> qt = new ArrayList<>();
    findPath(root, p, pt);
    findPath(root, q, qt);
  }

  private boolean findPath(TreeNode root, TreeNode node, List<TreeNode> path) {
    if(root == null) {
      return false;
    }
    path.add(root);
    if(root == node) {
      return true; 
    }
    if(findPath(root.left, node) || findPath(root.right, node)) {
      return true;
    }
    path.remove(path.size() - 1);
    return false;
  }
}
