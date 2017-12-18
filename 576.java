class Solution {
  public int findPaths(int m, int n, int N, int i, int j) {
    if (N == 0) {
      return 0;
    }
    long[][][] paths = new long[m][n][N];
    int large = 1000000007;
    long counts = 0;
    paths[i][j][0] = 1;
    if (i == 0) counts += 1;   
    if (j == 0) counts += 1;
    if (i == m - 1) counts += 1;
    if (j == n - 1) counts += 1;
    for (int k = 1; k < N; k++) {
      for (int p = 0; p < m; p++) {
        for (int q = 0; q < n; q++) {
          if (p - 1 >= 0) {
            paths[p][q][k] = (paths[p - 1][q][k - 1] + paths[p][q][k]) % large;
          }
          if (q - 1 >= 0) {
            paths[p][q][k] = (paths[p][q - 1][k - 1] + paths[p][q][k]) % large;
          }
          if (p + 1 < m) {
            paths[p][q][k] = (paths[p + 1][q][k - 1] + paths[p][q][k]) % large;
          }
          if (q + 1 < n) {
            paths[p][q][k] = (paths[p][q + 1][k - 1] + paths[p][q][k]) % large;
          }
          if (p == 0) {
            counts = (counts + paths[p][q][k]) % large;
          }
          if (q == 0) {
            counts = (counts + paths[p][q][k]) % large;
          }
          if (p == m - 1) {
            counts = (counts + paths[p][q][k]) % large;
          }
          if (q == n - 1) {
            counts = (counts + paths[p][q][k]) % large;
          }
        }
      }
    }
    return (int) counts;
  }
}
