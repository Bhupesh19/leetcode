class Solution {
  public int findNumberOfLIS(int[] nums) {
    int m = nums.length;
    int[] lens = new int[m];
    int[] counters = new int[m];
    int max = 0;
    int counter = 0;
    for(int i = 0; i < m; i++) {
      lens[i] = 1;
      counters[i] = 1;
      for(int j = 0; j < i; j++) {
        if(nums[i] > nums[j]) {
          if(lens[i] == lens[j] + 1) {
            counters[i] += counters[j];
          }
          if(lens[i] < lens[j] + 1) {
            lens[i] = lens[j] + 1;
            counters[i] = counters[j];
          }
        }
      }
      if(max == lens[i]) {
        counter += counters[i];
      }
      if(max < lens[i]) {
        max = lens[i];
        counter = counters[i];
      }
    }
    return counter;
  }
}
