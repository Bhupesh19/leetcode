class Solution {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

    Map<Integer, Map<Integer, Integer>> routes = new HashMap();
    for (int[] flight : flights) {
      if (!routes.containsKey(flight[0])) {
        routes.put(flight[0], new HashMap<Integer, Integer>());
      }
      routes.get(flight[0]).put(flight[1], flight[2]);
    }
        
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) ->  a[1] - b[1]);
    minHeap.offer(new int[]{src, 0, -1});
    while (!minHeap.isEmpty()) {
      int[] route = minHeap.poll();
      int source = route[0];
      int price = route[1];
      int stops = route[2];
      if (source == dst) {
        return price; 
      }
      if (!routes.containsKey(source)) {
        continue;
      }
      for (Map.Entry<Integer, Integer> entry : routes.get(source).entrySet()) {
        int target = entry.getKey();
        int p = entry.getValue();
        if (stops + 1 == K && target != dst) {
          continue;
        }
        minHeap.offer(new int[]{target, price + p, stops + 1});
      }
    }
    return -1;
  }
}
