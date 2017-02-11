public class Solution {
  public boolean isPalindrome(int x) {
    int rx = 0;
    int cx = x; 
    while(x > 0) {
      rx = rx * 10 + x % 10;
      x /= 10;
    }
    return rx == cx; 
  }
}
