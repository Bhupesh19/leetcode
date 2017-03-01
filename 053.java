public class Solution {
  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    if(nums.length == 0) {
      return max;
    } 
    int curr = max = nums[0];
    for(int i = 1; i < nums.length; i++) {
      curr = (curr + nums[i] > nums[i]) ? curr + nums[i] : nums[i];
      max = (max > curr) ? max : curr;
    }
    return max;
  }
}
