public class Solution {
  public int search(int[] nums, int target) {
    int index = -1;
    if(nums.length == 0) {
      return index;
    }
    int low = 0, high = nums.length - 1;
    index = binarySearch(nums, target, low, high);
    return index;
  }

  private int binarySearch(int[] nums, int target, int low, int high) {
    if(low == high) {
      if(nums[low] == target) {
        return low;
      } else {
        return -1;
      }
    }
    int mid = (low + high) / 2;
    if(nums[low] > nums[mid] || nums[mid+1] > nums[high] || nums[mid] > nums[mid+1]) {
      int index1 = binarySearch(nums, target, low, mid);
      int index2 = binarySearch(nums, target, mid+1, high);
      if(index1 != -1) {
        return index1;
      }
      if(index2 != -1) {
        return index2;
      }
      return -1;
    } else {
      if(target <= nums[mid]) {
        return binarySearch(nums, target, low, mid);
      } else {
        return binarySearch(nums, target, mid+1, high);
      }
    }
  }
}
