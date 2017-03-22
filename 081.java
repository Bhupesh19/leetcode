public class Solution {
  public boolean search(int[] nums, int target) {
    int index = -1;
    int low = 0, high = nums.length-1;
    while(low <= high) {
      int mid = (low + high) / 2;
      if(target == nums[mid]) {
        return true;
      }
      if(target < nums[mid]) {
        if(target < nums[high] && target ){
      
        } 
      } 
    } 
  }
}
