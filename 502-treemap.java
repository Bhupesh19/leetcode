class Solution {
  public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
    // the basic idea is that using a heap to store the profits which could be gained with the current capital, the heap will store all affordable profits
    // use a map to store all pairs (cap, list(pro1, pro2, pro3...)), namely the projects which are not affordable with a certain cap
    // after finish a project, update the map and heap
        
    Map<Integer, List<Integer>> capToProfits = new TreeMap();
    PriorityQueue<Integer> highestProfits = new PriorityQueue<>(Profits.length, (a, b) -> b - a);    

    for (int i = 0; i < Capital.length; i++) {
      int cap = Capital[i];
      if (cap <= W) {
        highestProfits.offer(Profits[i]);
      }
      if (cap > W) {
        if (!capToProfits.containsKey(cap)) {
          capToProfits.put(cap, new ArrayList<Integer>());
        }
        capToProfits.get(cap).add(Profits[i]);             
      }
    }
      
    for (int i = 1; i <= k; i++) {
      // if no project is possible
      if (highestProfits.size() == 0) {
        break;
      }
      int preW = W;
      W += highestProfits.poll();
      for (Map.Entry<Integer, List<Integer>> entry : capToProfits.entrySet()) {
        if (entry.getKey() > preW && entry.getKey() <= W) {
          for (int profit : entry.getValue()) {
            highestProfits.offer(profit);
          }
        }
        if (entry.getKey() > W) {
          break;
        }
      }
    }
    return W;
  }
}
