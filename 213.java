public class Solution {
  public int rob(int[] nums) {
    if(nums.length == 1) {
      return nums[0];
    }
    return Math.max(robPart(nums, 0, nums.length - 1), robPart(nums, 1, nums.length)); 
  }
  
  private int robPart(int[] nums, int low, int high) {
    int a = 0, b = 0;
    for(int i = low; i < high; i++) {
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
