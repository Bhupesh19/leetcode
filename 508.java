class Solution {
    
  private int max = 0;
  private Map<Integer, Integer> map = new HashMap<>();
  private Set<Integer> set = new HashSet<>();

  public int[] findFrequentTreeSum(TreeNode root) {
    getSum(root);
    int[] res = new int[set.size()];
    int i = 0;
    for (Integer sum : set) {
      res[i++] = sum;
    }
    return res;
  }
    
  private int getSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int sum = getSum(root.left) + getSum(root.right) + root.val;
    int curr = map.getOrDefault(sum, 0) + 1;
    if (curr > max) {
      max = curr;
      set = new HashSet<>();
      set.add(sum);
    } else if (curr == max) {
      set.add(sum);
    }
    map.put(sum, curr);
    return sum;
  }
}
