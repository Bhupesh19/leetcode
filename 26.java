public class Solution {
  public int removeDuplicates(int[] nums) {
    if(nums.length == 0) {
      return 0;
    }
    int i = 1, j = 1;
    while(i < nums.length) {
      while(i < nums.length && nums[i-1] == nums[i]) {
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
