class Solution {
  public int smallestDistancePair(int[] nums, int k) {
    PriorityQueue<int[]> pairs = new PriorityQueue<>(k, (a, b) -> (Math.abs(b[1] - b[0]) - Math.abs(a[1] - a[0])));
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      int[] first = new int[]{nums[i], nums[i+1]};
      if (pairs.size() == k && Math.abs(pairs.peek()[0] - pairs.peek()[1]) < Math.abs(first[0] - first[1])) {
        break;
      }
      for (int j = i + 1; j < nums.length; j++) {
        int[] cur = new int[]{nums[i], nums[j]};
        int[] top = pairs.peek();
        if (pairs.size() == k) {
          if (Math.abs(top[0] - top[1]) < Math.abs(cur[0] - cur[1])) {
            break;
          }
          pairs.poll();
          pairs.offer(cur);
        } else {
          pairs.offer(cur);                  
        }
      }
    }
    int[] results = pairs.poll();
    return Math.abs(results[0] - results[1]);
  }
}
