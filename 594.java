class Solution {
  public int findLHS(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int max = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      int count = entry.getValue();
      int maxCurr = 0;
      if (map.containsKey(key - 1)) {
        maxCurr = count + map.get(key - 1);
      }
      if (map.containsKey(key + 1)) {
        maxCurr = Math.max(maxCurr, count + map.get(key + 1));
      }
      max = Math.max(maxCurr, max);
    }
    return max;
  }
}
