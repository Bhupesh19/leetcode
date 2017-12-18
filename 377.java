class Solution {
  public int combinationSum4(int[] nums, int target) {
    int[] counts = new int[target + 1];
    Arrays.sort(nums);
    for (int i = 0; i < counts.length; i++) {
      for (int j = 0; j < nums.length && nums[j] <= i; j++) {
        if (i == nums[j]) {
          counts[i] += 1;
        } else {
          counts[i] += counts[i - nums[j]];
        }
      }
    }
    return counts[target];
  }
}
