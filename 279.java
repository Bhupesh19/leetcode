public class Solution {
  public int numSquares(int n) {
    int[] nums = new int[n + 1];
    for(int i = 1; i * i <= n; i++) {
      nums[i * i] = 1;
    }
    for(int i = 1; i <= n; i++) {
      if(nums[i] != 1) {
        nums[i] = Integer.MAX_VALUE;
        for(int j = 1; j * 2 <= i; j++) {
          nums[i] = Math.min(nums[j] + nums[i - j], nums[i]);
        }
      } 
    }
    return nums[n];
  }
}
