public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> pt = new ArrayList<>();
    List<TreeNode> qt = new ArrayList<>();
    findPath(root, p, pt);
    findPath(root, q, qt);
    int i = 0, j = 0;
    while(i < pt.size() && j < qt.size() && pt.get(i) == qt.get(j)) {
        i++;
        j++;
    }
    if(pt.size() <= 0 || qt.size() <= 0) {
        return null;
    }
    return pt.get(i - 1);
  }

  private boolean findPath(TreeNode root, TreeNode node, List<TreeNode> path) {
    if(root == null) {
      return false;
    }
    path.add(root);
    if(root == node || findPath(root.left, node, path) || findPath(root.right, node, path)) {
        return true;
    }
    path.remove(path.size() - 1);
    return false;
  }
}
