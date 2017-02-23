public class Solution {
  public int searchInsert(int[] nums, int target) {
    int index = -1;
    for(int i = 0; i < nums.length; i++) {
      if(target <= nums[i]) {
        index = i;
        break;
      }
    }
    if(index == -1) {
      index =  nums.length;
    }
    return index;
  }
}
