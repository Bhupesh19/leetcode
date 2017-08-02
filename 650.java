public class Solution {
  public int minSteps(int n) {
    int[] steps = new int[n + 1];
    for(int i = 2; i <= n; i++) {
      steps[i] = i;
      for(int j = i / 2; j > 1; j--) {
        if(i % j == 0) {
          steps[i] = steps[j] + i / j;
          break;
        }
      }
    }
    return steps[n];
  }
}
