public class Solution {
  public int climbStairs(int n) {
    int[] p = new int[n+1];
    p[0] = 1;
    p[1] = 1;
    for(int i = 2; i <= n; i++) {
      p[i] = p[i-2] + p[i-1];
    }
    return p[n]; 
  }
}
