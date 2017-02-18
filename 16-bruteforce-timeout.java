public class Solution {
  public int threeSumClosest(int[] nums, int target) {
    int sum = nums[0] + nums[1] + nums[2];
    for(int i = 0; i < nums.length-2; i++) {
      for(int j = i+1; j < nums.length-1; j++) {
        for(int k = j+1; k < nums.length; k++) {
          int tempSum = nums[i] + nums[j] + nums[k];
          if(Math.abs(sum-target) > Math.abs(tempSum-target)) {
            sum = tempSum;
          }
        }
      }
    }
    return sum;  
  }
}
