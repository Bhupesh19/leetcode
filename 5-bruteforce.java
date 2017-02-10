public class Solution {
  public String longestPalindrome(String s) {
    int odd_max = 0, even_max = 0;
    int odd_mid = 0, even_mid = 0;
    int curr = 0;
    for(int i = 0; i < s.length(); i++) {
      curr = 1;
      for(int j = 1; i-j >= 0 && i+j < s.length(); j++) {
        if(s.charAt(i-j) != s.charAt(i+j)) {
          break;
        }
        curr += 2; 
      }
      if(odd_max < curr) {
        odd_max = curr;
        odd_mid = i;
      }
    }
    for(int i = 0; i < s.length() - 1; i++) {
      curr = 0;
      for(int j = 0; i-j >= 0 && i+j+1 < s.length(); j++) {
        if(s.charAt(i-j) != s.charAt(i+j+1)) {
          break;       
        }
        curr += 2;
      }
      if(even_max < curr) {
        even_max = curr;
        even_mid = i;
      }
    }
    return (odd_max > even_max) ? s.substring(odd_mid-odd_max/2, odd_mid+odd_max/2+1) : s.substring(even_mid-even_max/2+1, even_mid+even_max/2+1); 
  }
}
