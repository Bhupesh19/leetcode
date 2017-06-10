public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> pt = new ArrayList<>();
    List<TreeNode> qt = new ArrayList<>();
    findPath(root, p, pt);
    findPath(root, q, qt);
    for(int i = pt.size() - 1; i >= 0; i--) {
      for(int j = qt.size() - 1; j >= 0; j--) {
        if(pt.get(i) == qt.get(j)) {
          return pt.get(i);
        }
      }
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
