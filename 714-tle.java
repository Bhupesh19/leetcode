class Solution {
  public int maxProfit(int[] prices, int fee) {
    int len = prices.length;
    if (len <= 1) {
      return 0;
    }
    // p[i] represent the largest profit we get on day i
    // p[i] = max(p[i - 1], p[i - 2] + prices[i] - prices[i - 1] - fee...)
    // p[0] = 
    int[] p = new int[len];
    for (int i = 0; i < len; i++) {
      if (i == 0) {
        p[i] = 0;
      } else if (i == 1) {
        p[i] = Math.max(0, prices[i] - prices[i - 1] - fee);
      } else {
        p[i] = Math.max(p[i - 1], prices[i] - prices[0] - fee);
        for (int j = i - 2; j >= 0; j--) {
          p[i] = Math.max(p[i], p[j] + prices[i] - prices[j + 1] - fee);
        }
      }
    }
    return p[len - 1];
  }
}
