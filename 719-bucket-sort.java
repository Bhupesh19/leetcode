class Solution {
  public int smallestDistancePair(int[] nums, int k) {
    // using heap to solve this problem will cause TLE error
    // consider using bucket sort, use the pair diff as the index of the new built array and the number of these diffs as value
    int[] diffToCounts = new int[1000000];
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        diffToCounts[Math.abs(nums[i] - nums[j])]++;
      }
    }
    int j = 0;
    for (int i = 1; i <= k; i++) {
      while (j < diffToCounts.length && diffToCounts[j] == 0) {
        j++;
      }
      diffToCounts[j]--;
      if (i == k) {
        return j;
      }
    }
    return -1;
  }
}
