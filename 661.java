class Solution {
    
  private int rn;
  private int cn;
  private int[][] M;

  public int[][] imageSmoother(int[][] M) {
    rn = M.length;
    cn = M[0].length;
    this.M = M;
    int[][] results = new int[rn][cn];
    for (int i = 0; i < rn; i++) {
      for (int j = 0; j < cn; j++) {
        results[i][j] = getOne(i, j);
      }
    }
    return results;
  }
    
  private int getOne(int i, int j) {
    int count = 0;
    int sum = 0;
    for (int m = i - 1; m <= i + 1; m++) {
      for (int n = j - 1; n <= j + 1; n++) {
        if (m >= 0 && m < rn && n >= 0 && n < cn) {
          count++;
          sum += M[m][n];
        }
      }
    }
    return sum / count;
  }
}
