class Solution {
  public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
    PriorityQueue<Integer> profits = new PriorityQueue<>((a, b) -> (b - a));
    PriorityQueue<int[]> capToProfits =  new PriorityQueue<>((a, b) -> (a[0] - b[0]));
    for (int i = 0; i < Capital.length; i++) {
      capToProfits.offer(new int[]{Capital[i], Profits[i]});
    }
    for (int i = 1; i <= k; i++) {
      while (!capToProfits.isEmpty() && capToProfits.peek()[0] <= W) {
        profits.offer(capToProfits.poll()[1]);
      }
      if (profits.isEmpty()) {
        break;
      }
      W += profits.poll();
    }
    return W;
  }
}
