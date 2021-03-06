class Solution {
  public boolean findTarget(TreeNode root, int k) {
    return dfs(root, new HashSet<Integer>(), k);    
  }

  private boolean dfs(TreeNode root, Set<Integer> set, int k) {
    if(root == null) return false;
    if(set.contains(k - root.val)) return true;
    set.add(root.val);
    return dfs(root.left, set, k) || dfs(root.right, set, k); 
  } 
}
