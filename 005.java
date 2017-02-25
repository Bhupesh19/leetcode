public class Solution {
  
  private int begin = 0, maxLen = 0; 

  public String longestPalindrome(String s) {
    if(s.length() < 2) {
      return s;
    }
    for(int i = 0; i < s.length() - 1; i++) {
      extendPalindrome(s, i, i);
      extendPalindrome(s, i, i + 1);
    }
    return s.substring(begin, begin + maxLen); 
  }
  
  private void extendPalindrome(String s, int left, int right) {
    while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    if(maxLen < right - left - 1) {
      begin = left + 1;
      maxLen = right - left - 1;
    }  
  }
}
