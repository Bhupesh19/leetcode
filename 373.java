class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // brute-force method: generate every pair and use PriorityQueue<int[]> (max heap)
        // improved: capacity control (k pairs in max heap), once a new pair comes, compare it with the root value of the heap; if the current number is larger than the root value, switch to the next line (and the capacity has already reached he maximal); 
    List<int[]> results = new ArrayList();
    PriorityQueue<int[]> sortedSums = new PriorityQueue<>(k, (a, b) -> (b[0] + b[1] - a[0] - a[1]));
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        int[] cur = new int[2];
        cur[0] = nums1[i];
        cur[1] = nums2[j];
        if (sortedSums.size() == k) {
          if (sortedSums.peek()[0] + sortedSums.peek()[1] <= cur[0] + cur[1]) {
            break;
          }
          sortedSums.poll();
          sortedSums.offer(cur);
        } else {
          sortedSums.offer(cur);
        }
      }
    }
    while (!sortedSums.isEmpty()) {
      results.add(0, sortedSums.poll());
    }
    return results;
  }
}
