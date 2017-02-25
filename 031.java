public class Solution {
  public void nextPermutation(int[] nums) {
    if(nums.length == 0) {
      return;
    }
    int index = 0;
    for(int i = nums.length-1; i > 0; i--) {
      if(nums[i] > nums[i-1]) {
        int temp = nums[i];
        nums[i] = nums[i-1];
        nums[i-1] = temp;
        return;
      } 
    }
    for(int i = 0; 2*i <= nums.length-1; i++) {
      int temp = nums[i];
      nums[i] = nums[nums.length-1-i];
      nums[nums.length-1-i] = temp;
    }
    return;
  }
}
