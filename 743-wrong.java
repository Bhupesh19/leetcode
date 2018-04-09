class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] s2tTimes = new int[N + 1][N + 1];
        int[] k2Times = new int[N + 1];
        int result = 0;
        // use a min heap to keep track of the adjacent nodes and update k2Times array
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        // initialize the initial time as infinite
        for (int i = 1; i <= N; i++) {
            if(i != K) {
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
                pq.offer(ele);
            }
        }
        
        Set<Integer> visitedNodes = new HashSet();
        
        while (!pq.isEmpty()) {
            int size = pq.size();
            PriorityQueue<int[]> temp = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            for (int i = 0; i < size; i++) {
                int[] e = pq.poll();
                if (visitedNodes.contains(e[0])) {
                    continue;
                }
                if (k2Times[e[1]] - k2Times[e[0]] - e[2] > 0) {
                    k2Times[e[1]] =  k2Times[e[0]] + e[2];
                }
                for (int j = 0; j < s2tTimes[e[1]].length; j++) {
                    if (s2tTimes[e[1]][j] != 0) {
                        int[] adjacents = new int[]{e[1], j, s2tTimes[e[1]][j]};
                        temp.offer(adjacents);
                    }
                }
                visitedNodes.add(e[0]);
            }
            pq = temp;
        }
        
        for (int time : k2Times) {
            if (time == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(time, result);
        }
        return result;
    }
}
