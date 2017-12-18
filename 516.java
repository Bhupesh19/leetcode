class Solution {
  public int longestPalindromeSubseq(String s) {
    int m = s.length();
    int[][] lens = new int[m][m];
    int max = 0;
    for (int j = 0; j < m; j++) {
      for (int i = j; i >= 0; i--) {
        if (i == j) {
          lens[i][j] = 1;
        } else {
          if (s.charAt(i) == s.charAt(j)) {
            lens[i][j] = lens[i + 1][j - 1] + 2;
          } else {
            lens[i][j] = Math.max(lens[i][j - 1], lens[i + 1][j]);
          }
        }
        max = Math.max(max, lens[i][j]);
      }
    }
    return max;
  }
}
