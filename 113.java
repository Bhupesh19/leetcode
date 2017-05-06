public class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> pSum = new ArrayList<>();
    sum(root, sum, pSum, res);
    return res;
  }

  private void sum(TreeNode root, int sum, List<Integer> pSum, List<List<Integer>> res) {
    if(root == null) {
      return;
    }
    if(root.left == null && root.right == null) {
      pSum.add(root.val);
      if(sum == root.val) {
        res.add(new ArrayList<Integer>(pSum));
      }
      pSum.remove(pSum.size()-1);
    }
    pSum.add(root.val);
    sum(root.left, sum - root.val, pSum, res);
    sum(root.right, sum - root.val, pSum, res);
    pSum.remove(pSum.size()-1);
  }
}
