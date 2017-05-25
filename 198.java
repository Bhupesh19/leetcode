public class Solution {
  public int rob(int[] nums) {
    if(nums.length == 0) {
      return 0;
    }
    if(nums.length == 1) {
      return nums[0];
    }
    int a = nums[0];
    int b = Math.max(nums[1], nums[0]);
    for(int i = 2; i < nums.length; i++) {
      if(a + nums[i] > b) {
        int temp = b;
        b = a + nums[i];
        a = temp;
      } else {
        a = b;
      } 
    }
    return b;
  }
}
