class Solution {
  public double findMaxAverage(int[] nums, int k) {
    int max = 0;
    int cur = 0;
    for(int i = 0; i < k; i++) {
      cur += nums[i];
    }
    max = cur;
    for(int i = k; i < nums.length; i++) {
      cur = cur + nums[i] - nums[i - k];
      max = Math.max(cur, max); 
    }
    return max * 1.0 / k;
  }
}
