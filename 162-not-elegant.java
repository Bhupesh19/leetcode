public class Solution {
  public int findPeakElement(int[] nums) {
    int low = 0, high = nums.length - 1;
    while(low <= high) {
      int middle = (low + high) / 2;
      if(middle == 0) {
        return (nums[middle] > nums[high]) ? middle : high;
      }
      if(middle == nums.length - 1) {
        return (nums[middle] > nums[low]) ? middle : low;
      }
      if(nums[middle] >= nums[middle - 1] && nums[middle] >= nums[middle + 1]) {
        return middle;
      } else if(nums[middle] < nums[middle - 1]) {
        high = middle - 1;
      } else {
          low = middle + 1;
      }
    }
    return low;
  }
}
