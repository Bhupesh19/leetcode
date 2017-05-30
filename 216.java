public class Solution {

  private Set<List<Integer>> res = new HashSet<>();

  public List<List<Integer>> combinationSum3(int k, int n) {
    findSum(0, 0, k, n, new ArrayList<Integer>());
    return new ArrayList<List<Integer>>(res);
  }

  private void findSum(int level, int sum, int k, int n, List<Integer> curr) {
    if(level == k || sum >= n) {
      if(sum == n && curr.size() == k) {
        res.add(new ArrayList<Integer>(curr));
      }
      return;
    }
    int init = 0;
    if(curr.size() > 0) {
      init = curr.get(curr.size() - 1);
    }
    for(int i = init + 1; i <= 9; i++) {
      if(sum + i <= n) {
        curr.add(i);
        findSum(level + 1, sum + i, k, n, curr);
        curr.remove(curr.size() - 1);
      } 
    }
  }
}
