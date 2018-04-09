class Solution {
  public int networkDelayTime(int[][] times, int N, int K) {
    int[][] s2tTimes = new int[N + 1][N + 1];
    int[] k2Times = new int[N + 1];
    // use a min heap to keep track of the adjacent nodes and update k2Times array
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
    // initialize the initial time as infinite
    for (int i = 1; i <= N; i++) {
      if (i != K) {
        k2Times[i] = Integer.MAX_VALUE;
      }
    }
        
    // s2tTimes[a][b] represents the time from a to b
    for (int[] ele : times) {
      int source = ele[0];
      int target = ele[1];
      int time = ele[2];
      s2tTimes[source][target] = time;
      if (source == K) {
        pq.offer(new int[]{K, 0});
      }
    }
        
    while (!pq.isEmpty()) {
      int[] e = pq.poll();
      if (k2Times[e[0]] != Integer.MAX_VALUE && e[0] != K && k2Times[e[0]] < e[1]) {
        continue;
      }
      for (int i = 0; i < s2tTimes[e[0]].length; i++) {
        // s2tTimes[e[0]][i] != 0 indicates the existence of the edge
        if (s2tTimes[e[0]][i] != 0) {
          // k2Times[i] != Integer.MAX_VALUE indicates the node i has been processed before
          // k2Times[i] < e[1] + s2tTimes[e[0]][i] indicates the distance of (K, i) is less than (K, )
          if (k2Times[i] != Integer.MAX_VALUE && k2Times[i] < e[1] + s2tTimes[e[0]][i]) {
            continue;
          }
          k2Times[i] = e[1] + s2tTimes[e[0]][i];
          pq.offer(new int[]{i, k2Times[i]});
        }
      }
    }
        
    int max = -1;
    for (int time : k2Times) {
      if (time == Integer.MAX_VALUE) {
        return -1;
      }
      max = Math.max(time, max);
    }
    return max;
  }
}
