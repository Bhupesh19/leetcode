public class Solution {
  
  private List<List<Integer>> res = new ArrayList<>();
  
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    traverse(root, 0);
    Collections.reverse(res);
    return res;
  }
  
  private void traverse(TreeNode tree, int h) {
    if(tree == null) {
      return;
    }
    if(res.size() <= h) {
      List<Integer> newLevel = new ArrayList<>();
      res.add(newLevel);  
    }
    res.get(h).add(tree.val);
    traverse(tree.left, h+1);
    traverse(tree.right, h+1);
    return;
  }
}
