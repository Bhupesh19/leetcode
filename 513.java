class Solution {
  public int findBottomLeftValue(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while(!q.isEmpty()) {
      int size = q.size();
      res.add(q.peek().val);
      for(int i = 0; i < size; i++) {
        TreeNode cur = q.poll();
        if(cur.left != null) q.offer(cur.left);
        if(cur.right != null) q.offer(cur.right);
      }
    }
    return res.get(res.size() - 1);
  }
}
