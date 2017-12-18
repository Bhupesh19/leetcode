class Solution {
  public int minCostClimbingStairs(int[] cost) {
    int len = cost.length;
    if (len == 0) {
      return 0;
    }
    int[] minCosts = new int[len];
    for (int i = 0; i < len; i++) {
      if (i < 2) {
        minCosts[i] = cost[i];
      } else {
        minCosts[i] = Math.min(minCosts[i - 2], minCosts[i - 1]) + cost[i];
      }
    }
    if (len < 2) {
      return minCosts[len - 1];
    }
    return Math.min(minCosts[len - 1], minCosts[len - 2]);
  }
}
