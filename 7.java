public class Solution {
  public int reverse(int x) {
    long rx = 0;
    while(x != 0) {
      rx = rx * 10 + x % 10;
      x /= 10;
    }
    if(rx < Integer.MIN_VALUE || rx > Integer.MAX_VALUE) {
      return 0;
    } else {
      return (int) rx;
    }
  }
}
