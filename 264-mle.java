public class Solution {
  public int nthUglyNumber(int n) {
    boolean[] isUglyNumber = new boolean[Integer.MAX_VALUE];
    isUglyNumber[1] = true;
    for(int i = 2; i < Integer.MAX_VALUE; i++) {
      if(i % 2 == 0) {
        isUglyNumber[i] = isUglyNumber[i / 2];
      }
      if(i % 3 == 0) {
        isUglyNumber[i] = isUglyNumber[i / 3] || isUglyNumber[i];
      }
      if(i % 5 == 0) {
        isUglyNumber[i] = isUglyNumber[i / 5] || isUglyNumber[i];
      }
    }
    int num = 0;
    int count = 0;
    for(int i = 0; i < Integer.MAX_VALUE; i++) {
      if(isUglyNumber[i]) {
        count++;
        if(count == n) {
          num = i;
          break;
        }
      }
    }
    return num;
  }
}
