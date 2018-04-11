class Solution {
  public int swimInWater(int[][] grid) {
    // the idea is using adapted Dijkstra algorithm, each grid could be considered as a 
    // each element in heap consists of (i, j, v) where v is the possible smallest value among all passed blocks
    int m = grid.length;
    int[][] times = new int[m][m];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < m; j++) {
        times[i][j] = Integer.MAX_VALUE;
      }
    }
    times[0][0] = 0;
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    int src = grid[0][0];
    minHeap.offer(new int[]{0, 0, src});
    int[][] d = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    while (!minHeap.isEmpty()) {
      int[] curBlock = minHeap.poll();
      int rowNum = curBlock[0];
      int colNum = curBlock[1];
      int time = curBlock[2];
      if (rowNum == m - 1 && colNum == m - 1) {
        return time;
      }
      for (int i = 0; i < 4; i++) {
        if (rowNum + d[i][0] < 0 || rowNum + d[i][0] >= m || colNum + d[i][1] < 0 || colNum + d[i][1] >= m) {
          continue;
        }
        int nextRow = rowNum + d[i][0];
        int nextCol = colNum + d[i][1];
        if (times[nextRow][nextCol] != Integer.MAX_VALUE) {
          continue;
        }
        int t = Math.max(grid[nextRow][nextCol], time);
        times[nextRow][nextCol] = t;
        minHeap.offer(new int[]{nextRow, nextCol, t});
      }
    }
    return -1;
  }
}
