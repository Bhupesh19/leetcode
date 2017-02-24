public class Solution {
  public int searchInsert(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    int mid = (low + high) / 2;
    while(low < high) {
      if(target <= nums[mid]) {
        high = mid;
      } else {
        low = mid + 1;
      }
      mid = (low + high) / 2;
    }
    if(nums.length == 0 || (high == nums.length - 1 && target > nums[nums.length-1])) {
      return nums.length;
    }
    return high;
  }
}
