public class Solution {
  public String longestPalindrome(String s) {
    int oddMax = 0, evenMax = 0;
    int oddMid = 0, evenMid = 0;
    int curr = 0;
    for(int i = 0; i < s.length(); i++) {
      curr = 1;
      for(int j = 1; i - j >= 0 && i + j < s.length(); j++) {
        if(s.charAt(i - j) != s.charAt(i + j)) {
          break;
        }
        curr += 2; 
      }
      if(oddMax < curr) {
        oddMax = curr;
        oddMid = i;
      }
    }
    for(int i = 0; i < s.length() - 1; i++) {
      curr = 0;
      for(int j = 0; i - j >= 0 && i + j + 1 < s.length(); j++) {
        if(s.charAt(i - j) != s.charAt(i + j + 1)) {
          break;       
        }
        curr += 2;
      }
      if(evenMax < curr) {
        evenMax = curr;
        evenMid = i;
      }
    }
    return (oddMax > evenMax) ? s.substring(oddMid - oddMax / 2, oddMid + oddMax / 2 + 1) : s.substring(evenMid - evenMax / 2 + 1, evenMid + evenMax / 2 + 1); 
  }
}
