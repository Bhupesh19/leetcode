class Solution {
  public int countSubstrings(String s) {
    int counter = 0;
    int len = s.length();
    boolean[][] isPanlindrome = new boolean[len][len];
    for (int j = 0; j < len; j++) {
      for (int i = 0; i < len; i++) {
        if (i == j) {
          isPanlindrome[i][j] = true;
          counter++;
        }
        if (i == j - 1 && s.charAt(i) == s.charAt(j)) {
          isPanlindrome[i][j] = true;
          counter++;
        }
        if (i < j - 1 && s.charAt(i) == s.charAt(j)) {
          isPanlindrome[i][j] = isPanlindrome[i + 1][j - 1];
          if (isPanlindrome[i][j]) {
            counter++;
          }
        }
      }
    }
    return counter;
  }
}
