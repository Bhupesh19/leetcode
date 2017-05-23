public class Solution {
  public int maxProduct(int[] nums) {
    int max = Integer.MIN_VALUE;
    int[][] p = new int[nums.length][nums.length];
    for(int j = 0; j < nums.length; j++) {
      for(int i = nums.length - 1; i >= 0; i--) {
        if(i > j) {
          p[i][j] = Integer.MIN_VALUE;
        } else if(i == j) {
          p[i][j] = nums[i];
        } else {
          p[i][j] = p[i+1][j] * nums[i];
        }
        max = Math.max(max, p[i][j]);
      }
    }
    return max;
  }
}
