class Solution {
  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] steps = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          steps[i][j] = (i == 0) ? j : i;
        } else {
          if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            steps[i][j] = Math.min(steps[i - 1][j - 1], steps[i][j - 1] + 1);
            steps[i][j] = Math.min(steps[i][j], steps[i - 1][j] + 1);
          } else {
            steps[i][j] = Math.min(steps[i - 1][j - 1] + 2, steps[i][j - 1] + 1);
            steps[i][j] = Math.min(steps[i][j], steps[i - 1][j] + 1);
          }
        }
      }
    }
    return steps[m][n];
  }
}
