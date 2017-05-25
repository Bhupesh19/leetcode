public class Solution {
  public int findMin(int[] nums) {
    int low = 0, high = nums.length - 1;
    while(low <= high) {
      int middle = (low + high) / 2;
      if(middle == 0) {
        return Math.min(nums[middle], nums[high]);
      }
      if(nums[middle - 1] > nums[middle]) {
        return nums[middle];
      }
      // minimum on the right half of the array is easier
      if(nums[high] < nums[middle]) {
        low = middle + 1;
      } else {
        high = middle - 1;
      }
    }
    return nums[low];
  }
}
