class Solution {
  public int[] findDiagonalOrder(int[][] matrix) {
    if(matrix == null || matrix.length == 0) return new int[0]; 
    int m = matrix.length, n = matrix[0].length;
    int i = 0, j = 0;
    int[] res = new int[m * n];
    boolean up = true;
    for(int k = 0; k < m * n; k++) {
      res[k] = matrix[i][j];
      i = (up) ? i - 1 : i + 1;
      j = (up) ? j + 1 : j - 1;
      if(i >= m) { i = m - 1; j = j + 2; up = true; }
      if(j >= n) { j = n - 1; i = i + 2; up = false; }
      if(i < 0) { i = 0; up = false; }
      if(j < 0) { j = 0; up = true; }
    }
    return res;
  }
}
