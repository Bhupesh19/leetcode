public class Solution {
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> res = new ArrayList<>();
    if(root == null) return res;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while(!q.isEmpty()) {
      int n = q.size();
      double sum = 0;
      for(int i = 0; i < n; i++) {
        TreeNode curr = q.poll();
        if(curr.left != null) q.offer(curr.left);
        if(curr.right != null) q.offer(curr.right);
        sum += curr.val;
      }
      res.add(sum / n); 
    }
    return res;
  }
}
