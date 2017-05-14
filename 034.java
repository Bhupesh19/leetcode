public class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[] {-1, -1};
    int low = 0, high = nums.length - 1;
    while(low <= high) {
      int middle = (low + high) / 2;
      if(nums[middle] < target) {
        low = middle + 1;
      } else if(nums[middle] > target) {
        high = middle - 1;
      } else {
        if(middle == 0 || middle - 1 >= 0 && nums[middle - 1] < target) {
          res[0] = middle;
          break;
        } else {
          high = middle - 1;
        }
      }
    }
    low = 0;
    high = nums.length - 1;
    while(low <= high) {
      int middle = (low + high) / 2;
      if(nums[middle] > target) {
        high = middle - 1;
      } else if(nums[middle] < target) {
        low = middle + 1;
      } else {
        if(middle == nums.length - 1|| nums[middle + 1] > target) {
          res[1] = middle;
          break;
        } else {
          low = middle + 1;
        }
      }
    }
    return res;
  }
}
