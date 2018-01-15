class Solution {
  public int arrayNesting(int[] nums) {
    int len = 0;
    for (int i = 0; i < nums.length; i++) {
      Set<Integer> set = new HashSet<>();
      int j = i;
      while (set.add(nums[j])) {
        j = nums[j];
      }
      len = Math.max(len, set.size());
    }
    return len;
  }
}
