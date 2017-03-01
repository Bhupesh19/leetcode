public class Solution {
  public boolean canJump(int[] nums) {
    if(nums.length == 0) {
      return false;
    }
    int steps = nums[0];
    for(int i = 1; i < nums.length; i++) {
      steps--; 
      if(steps < 0) {
        return false;
      }
      steps = (steps >= nums[i]) ? steps : nums[i];
    }
    return true; 
  }
}
