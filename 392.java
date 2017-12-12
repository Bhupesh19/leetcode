class Solution {
  public boolean isSubsequence(String s, String t) {
    int m = s.length();
    int n = t.length();
    if (m == 0) {
      return true;
    }
    if (n == 0) {
      return false;
    }
    boolean[][] isSub = new boolean[m][n];
    // isSub[i][j] indicates that whether s[0...i] is a subsequence of t[0...j]
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < m; i++) {
        if (s.charAt(i) == t.charAt(j)) {
          if (i == 0) {
            isSub[i][j] = true;
          }
          if (i > 0 && j > 0) {
            isSub[i][j] = isSub[i - 1][j - 1];
          }
        } else if (j > 0) {
          isSub[i][j] = isSub[i][j - 1];
        }
      }
    }
    return isSub[m - 1][n - 1];
  }
}
