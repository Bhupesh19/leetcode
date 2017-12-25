class Solution {
  public int maxProfit(int[] prices, int fee) {
    int len = prices.length;
    int[] hold = new int[len];
    int[] unhold = new int[len];
    hold[0] = -prices[0];
    for (int i = 1; i < len; i++) {
      hold[i] = Math.max(hold[i - 1], unhold[i - 1] - prices[i]);
      unhold[i] = Math.max(hold[i - 1] + prices[i] - fee, unhold[i - 1]);
    }
    return unhold[len - 1];
  }
}
