public class Solution {
  public double myPow(double x, int n) {
    if(n == 0) {
      return 1;
    }
    double res = 0.0;
    if(n == Integer.MIN_VALUE) {
      n /= 2;
      x *= x;
    }
    if(n < 0) {
      n = -n;
      x = 1 / x;
    }
    if(n % 2 == 0) {
      double mult = myPow(x, n/2);
      return mult * mult;
    } else {
      double mult = myPow(x, n/2);
      return mult * mult * x;
    }
  }
}
