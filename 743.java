class Solution {
  public int networkDelayTime(int[][] times, int N, int K) {
    int[][] edges = new int[N + 1][N + 1];
    int[] distance = new int[N + 1];
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
    // initialize the initial time as infinite
    for (int i = 1; i <= N; i++) {
      if (i != K) {
        distance[i] = Integer.MAX_VALUE;
      }
    }
      
    for (int i = 0; i <= N; i++) {
      for (int j = 0; j <= N; j++) {
        edges[i][j] = -1;      
      }
    }
        
    // edges[a][b] represents the time from a to b
    for (int[] ele : times) {
      edges[ele[0]][ele[1]] = ele[2];
    }

    pq.offer(new int[]{K, 0});
    while (!pq.isEmpty()) {
      int[] e = pq.poll();
      int source = e[0];
      int currDistance = e[1];
      if (distance[source] < currDistance) {
        continue;
      }
      for (int target = 1; target < edges[source].length; target++) {
        // edges[source][target] != 0 indicates the existence of the edge
        if (edges[source][target] != -1) {
          // distance[target] != Integer.MAX_VALUE indicates the node i has been processed before
          // distance[target] < currDistance + edges[source][target] indicates the distance of (K, target) is less than (K, src) + (src, target)
          if (distance[target] <= currDistance + edges[source][target]) {
            continue;
          }
          distance[target] = currDistance + edges[source][target];
          pq.offer(new int[]{target, distance[target]});
        }
      }
    }
        
    int max = -1;
    for (int time : distance) {
      if (time == Integer.MAX_VALUE) {
        return -1;
      }
      max = Math.max(time, max);
    }
    return max;
  }
}

