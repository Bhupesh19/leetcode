public class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null || q == null) {
      return p == q;
    }
    Stack<TreeNode> ps = new Stack<>();
    Stack<TreeNode> qs = new Stack<>();
    ps.push(p); 
    qs.push(q);
    while(!ps.isEmpty && !qs.isEmpty) {
      TreeNode a = ps.pop();
      TreeNode b = qs.pop();
      if(a.val != b.val) {
        return false;
      }
    }
    if(p == null || q == null) {
      return p == q;
    }
    return true;
  }
}
