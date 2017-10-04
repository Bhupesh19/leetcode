class Solution {
  public int findLengthOfLCIS(int[] nums) {
    int start = 0;
    int max = 0;
    for(int i = 0; i < nums.length; i++) {
      if(i > 0) {
        if(nums[i] > nums[i - 1]) {
          max = Math.max(max, i - start + 1); 
        } else {
          start = i;
        }
      } else {
        max = 1;
      }
    }
    return max;
  }
}
