public class Solution {
  public int[][] generateMatrix(int n) {
    int[][] res = new int[n][n];
    if(n == 0) {
      return res; 
    }
    int rowBegin = 0, rowEnd = n - 1;
    int colBegin = 0, colEnd = n - 1;
    int i = 1;
    while(rowBegin <= rowEnd && colBegin <= colEnd) {
      for(int m = colBegin; m <= colEnd; m++) {
        res[rowBegin][m] = i;
        i++;
      }
      rowBegin++;
      for(int k = rowBegin; k <= rowEnd; k++) {
        res[k][colEnd] = i;
        i++;
      }
      colEnd--;
      for(int m = colEnd; m >= colBegin; m--) {
        res[rowEnd][m] = i;
        i++; 
      }
      rowEnd--;
      for(int k = rowEnd; k >= rowBegin; k--) {
        res[k][colBegin] = i;
        i++;
      }
      colBegin++;
    }
    return res; 
  }
}
