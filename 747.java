class Solution {
  public int dominantIndex(int[] nums) {
    int max = Integer.MIN_VALUE;
    int sec = Integer.MIN_VALUE;
    int maxIndex = -1;
    int secIndex = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= max) {
        sec = max;
        secIndex = maxIndex;
        max = nums[i];
        maxIndex = i;
      } else if (nums[i] > sec) {
        sec = nums[i];
        secIndex = i;
      }
    }
    return (max >= 2 * sec) ? maxIndex : -1;
  }
}
