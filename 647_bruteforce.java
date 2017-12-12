class Solution {
  public int countSubstrings(String s) {
    int counter = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        if (isPanlindrome(s.substring(i, j + 1))) {
          counter++;
        }
      }
    }
    return counter;
  }
    
  private boolean isPanlindrome(String s) {
    int len = s.length();
    // i < s.length() - i - 1
    for (int i = 0; 2 * i + 1 < len; i++) {
      if (s.charAt(i) != s.charAt(len - i - 1)) {
        return false;
      }
    }
    return true;
  }
 
}
