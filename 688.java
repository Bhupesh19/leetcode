class Solution {
    
  int[][] moves = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
  
  public double knightProbability(int N, int K, int r, int c) {
    double[][] p = new double[N][N];
    p[r][c] = 1;
    for(int k = 0; k < K; k++) {
      double[][] temp = new double[N][N];
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
          for(int[] move : moves) {
            int row = i + move[0];
            int col = j + move[1];
            if(row >= 0 && row < N && col >= 0 && col < N) {
              temp[i][j] += p[row][col] / 8.0;
            }
          }
        }
      }
      p = temp;
    }
    double sum = 0;
    for(double[] pro : p) {
      for(double prob : pro) {
        sum += prob;
      }
    }
    return sum;
  }
}
