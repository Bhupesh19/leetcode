public class Solution {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    if(n == 0 || n < k) {
      return res;
    }
    combineKnumbers(res, new ArrayList<Integer>(), 0, n, k);
    return res;
  }

  private void combineKnumbers(List<List<Integer>> res, List<Integer> comb, int level, int n, int k) {
    if(level == k) {
      res.add(comb);
      return;
    }
    int last = 0;
    if(comb.size() != 0) {
      last = comb.get(comb.size()-1);
    } 
    for(int i = last+1; i <= n; i++) {
      comb.add(i);
      combineKnumbers(res, comb, level+1, n, k);
      comb.remove(level);
    }
  }
}
