public class Solution {
  public boolean search(int[] nums, int target) {
    int index = -1;
    int low = 0, high = nums.length-1;
    while(low <= high) {
      int mid = (low + high) / 2;
      if(target == nums[mid]) {
        return true;
      }
      if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
        low++;
        high--;
      } else if(target < nums[mid]) {
        if(target <= nums[high] && nums[mid] > nums[high]){
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      } else {
        if(target >= nums[low] && nums[mid] < nums[low]) {
          high = mid - 1;  
        } else {
          low = mid + 1;
        }
      } 
    }
    return false;
  }
}
