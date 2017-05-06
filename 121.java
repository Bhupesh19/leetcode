public class Solution {
  public int maxProfit(int[] prices) {
    int profit = 0;
    int min = Integer.MAX_VALUE;
    for(int price : prices) {
      profit = (profit > price - min) ? profit : price - min;
      min = (min < price) ? min : price;
    }
    return profit;
  }
}
