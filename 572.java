public class Solution {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if(s == null) return false;
    return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  private boolean isSame(TreeNode s, TreeNode t) {
    if(t == null && s == null) return true;
    if(t == null || s == null) return false;
    return t.val == s.val && isSame(s.left, t.left) && isSame(s.right, t.right);
  }
}
