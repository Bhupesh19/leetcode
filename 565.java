class Solution {
  public int arrayNesting(int[] nums) {
    int len = 0;
    Set<Integer> used = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (!used.contains(nums[i])) {
        int j = i;
        Set<Integer> set = new HashSet<>();
        while (set.add(nums[j])) {
          used.add(nums[j]);
          j = nums[j];
        }
        len = Math.max(len, set.size());
      }
    }
    return len;
  }
}
