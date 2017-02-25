public class Solution {
  public int removeElement(int[] nums, int val) {
    int i = 0, j = 0;
    while(i < nums.length) {
      while(i < nums.length && nums[i] == val) {
        i++;
      }
      if(i < nums.length) {
        nums[j] = nums[i];
        i++;
        j++;
      }
    }
    return j; 
  }
}
