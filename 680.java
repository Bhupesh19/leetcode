class Solution {
  public boolean validPalindrome(String s) {
    boolean hasOne = false;
    int i = 0, j = s.length() - 1;
    while(i < j) {
      if(s.charAt(i) != s.charAt(j)) {
        if(hasOne) return false;
        hasOne = true;
        if(j - 1 >= 0 && s.charAt(i) == s.charAt(j - 1)) {
          --j;
        } else if(i + 1 < s.length() && s.charAt(i + 1) == s.charAt(j)) {
          ++i;
        }
      }
      ++i;
      --j;
    }
  return true;
  }
}
