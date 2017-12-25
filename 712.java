class Solution {
  public int minimumDeleteSum(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    int[][] p = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 && j > 0) {
          p[0][j] = p[0][j - 1] + (int) (s2.charAt(j - 1));
        }
        if (j == 0 && i > 0) {
          p[i][0] = p[i - 1][0] + (int) (s1.charAt(i - 1));
        }
        if (i > 0 && j > 0) {
          if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            p[i][j] = Math.min(p[i - 1][j - 1], p[i - 1][j] + (int) s1.charAt(i - 1));
            p[i][j] = Math.min(p[i][j], p[i][j - 1] + (int) s2.charAt(j - 1));
          } else {
            p[i][j] = Math.min(p[i - 1][j - 1] + (int) s1.charAt(i - 1) + (int) s2.charAt(j - 1), p[i - 1][j] + (int) s1.charAt(i - 1));
            p[i][j] = Math.min(p[i][j], p[i][j - 1] + (int) s2.charAt(j - 1));
          }
        }
      }
    }
    return p[m][n];
  }
}
