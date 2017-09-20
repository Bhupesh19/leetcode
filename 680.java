class Solution {
  public boolean validPalindrome(String s) {
    int i = 0, j = s.length() - 1;
    while(i < j) {
      if(s.charAt(i) != s.charAt(j)) {
        if(s.charAt(i + 1) == s.charAt(j) && isPalindrome(s, i + 1, j)) {
          return true;
        } else if(s.charAt(i) == s.charAt(j - 1) && isPalindrome(s, i, j - 1)) {
          return true;
        } else {
          return false;
        }
      }
      ++i;
      --j;
    }
    return true;
  }

  private boolean isPalindrome(String s, int i, int j) {
    while(i < j) {
      if(s.charAt(i) != s.charAt(j)) {
        return false;
      }
      ++i;
      --j;
    }
    return true;
  }
}
