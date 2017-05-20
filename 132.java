public class Solution {

  public int minCut(String s) {
    boolean[][] pre = isPalindrome(s);
    int[] cut = new int[s.length() + 1];
    for(int i = 1; i < cut.length; i++) {
      int min = Integer.MAX_VALUE;
      for(int j = i; j > 0; j--) {
        if(pre[j-1][i-1]) {
          min = Math.min(min, cut[j-1] + 1); 
        }
      }
      cut[i] = min;
    }
    return (cut[s.length()] > 0 ) ? cut[s.length()] - 1 : 0;
  }

  private boolean[][] isPalindrome(String s) {
    boolean[][] res = new boolean[s.length()][s.length()];
    // res[i][j] indicates whether the substring from i to j (inclusive) is a palindrome
    // res[i][j] = res[i+1][j-1] if s.charAt(i) == s.charAt(j) i+1 <= j-1
    for(int j = 0; j < s.length(); j++) {
      for(int i = 0; i < s.length(); i++) {
        if(i == j || (i + 1 == j && s.charAt(i) == s.charAt(j))) {
          res[i][j] = true;
        }
        if(i + 1 <= j - 1 && s.charAt(i) == s.charAt(j)) {
          res[i][j] = res[i+1][j-1];
        }
      }
    }
    return res;
  }
}
