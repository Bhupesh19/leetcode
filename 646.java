public class Solution {
  public int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
    int[] num = new int[pairs.length + 1];
    num[1] = 1;
    for(int i = 2; i < num.length; i++) {
      for(int j = i - 1; j > 0; j--) {
        if(pairs[i - 1][0] > pairs[j - 1][1]) {
          num[i] = num[j] + 1;
          break;
        }
      }
      num[i] = Math.max(num[i], num[i - 1]);
    }
    return num[pairs.length];
  }
}
