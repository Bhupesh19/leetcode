public class Solution {
  public int maxProduct(int[] nums) {
    if(nums.length == 0) {
      return 0;
    }
    int maxTemp = nums[0];
    int minTemp = nums[0];
    int max = nums[0];
    for(int i = 1; i < nums.length; i++) {
      if(nums[i] < 0) {
        int temp = maxTemp;
        maxTemp = minTemp;
        minTemp = temp;
      }
      maxTemp = Math.max(maxTemp * nums[i], nums[i]);
      minTemp = Math.min(minTemp * nums[i], nums[i]);
      max = Math.max(maxTemp, max);
    }
    return max;
  }
}
