class Solution {
  public boolean isToeplitzMatrix(int[][] matrix) {
    int rn = matrix.length;
    int cn = matrix[0].length;
    for (int i = 0; i < rn; i++) {
      int m = i;
      int n = 0;
      int ele = matrix[m][n];
      while (m < rn && n < cn) {
        if (matrix[m][n] != ele) {
          return false;
        }
        m++;
        n++;
      }
    }
    for (int j = 1; j < cn; j++) {
      int m = 0;
      int n = j;
      int ele = matrix[m][n];
      while (m < rn && n < cn) {
        if (matrix[m][n] != ele) {
          return false;
        }
        m++;
        n++;
      }
    }
    return true;
  }
}
