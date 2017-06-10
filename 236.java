public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> pt = new ArrayList<>();
    List<TreeNode> qt = new ArrayList<>();
    findPath(root, p, pt);
    findPath(root, q, qt);
    int i = 0;
    while(i < pt.size() && i < qt.size()) {
      if(i + 1 == pt.size() || i + 1 == pt.size() || pt.get(i + 1) != qt.get(i + 1)) {
        return pt.get(i);
      }
      i++;
    }
    return null;
  }

  private boolean findPath(TreeNode root, TreeNode node, List<TreeNode> path) {
    if(root == null) {
      return false;
    }
    path.add(root);
    if(root == node) {
      return true; 
    }
    if(findPath(root.left, node, path) || findPath(root.right, node, path)) {
      return true;
    }
    path.remove(path.size() - 1);
    return false;
  }
}
