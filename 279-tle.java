public class Solution {

  private int num = Integer.MAX_VALUE;

  public int numSquares(int n) {
    countSquares(0, n);
    return num;
  }

  private void countSquares(int number, int left) {
    if(left == 0) {
      num = Math.min(number, num);
      return;
    }
    int max = (int) Math.floor(Math.sqrt(left));
    for(int i = max; i > 0; i--) {
      countSquares(number + 1, left - i * i);
    }
  }
}
