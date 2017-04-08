public class Solution {
 
  private List<List<Integer>> res = new ArrayList<>(); 
 
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    traverse(root, 0);
    for(int i = 0; i < res.size(); i++) {
      if(i % 2 == 1) {
        Collections.reverse(res.get(i));
      }
    }
    return res;
  }

  private void traverse(TreeNode tree, int height) {
    if(tree == null) {
      return;
    }
    int h = height + 1;
    if(res.size() < h) {
      List<Integer> level = new ArrayList<>();
      res.add(level); 
    }
    res.get(height).add(tree.val);
    traverse(tree.left, h);
    traverse(tree.right, h); 
  }
}
