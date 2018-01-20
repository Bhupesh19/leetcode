class Solution {
  public int findMaxLength(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int curr = 0;
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        curr++;
      } else {
        curr--;
      }
      if (map.containsKey(curr)) {
        max = Math.max(max, i - map.get(curr));
      } else {
        map.put(curr, i);
      }
    }
    return max;
  }
}
