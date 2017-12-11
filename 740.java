class Solution {
  public int deleteAndEarn(int[] nums) {
    int[] p = new int[10001];
    int[] res = new int[10001];
    for (int num : nums) {
      p[num]++;
    }
    res[1] = p[1];
    for (int i = 2; i < p.length; i++) {
      res[i] = Math.max(res[i - 1], res[i - 2] + p[i] * i);
    }
    return res[10000];
  }
}
