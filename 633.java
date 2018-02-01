class Solution {
  public boolean judgeSquareSum(int c) {
    int r = (int) Math.sqrt(c);
    int l = 0;
    while (r >= l) {
      if (r * r + l * l == c) {
        return true;
      }
      if (r * r + l * l > c) {
        r--;
      }
      if (r * r + l * l < c) {
        l++;
      }
    }
    return false;
  }
}
