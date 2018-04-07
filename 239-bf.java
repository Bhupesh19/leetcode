class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    // brute-force: keep all elements in a max heap with k capacity and every time peek the root element, remove the head element of the sliding and add the last one
    // brute-force time complexity: n - k windows, build heap: k*logk, run: (n - k) * max(logk, k) = (n - k) * k
    if (k == 0) {
      return new int[0];
    }
    PriorityQueue<Integer> numbers = new PriorityQueue<>(k, (a, b) -> (b - a));
    int[] results = new int[nums.length - k + 1];
    for (int i = 0; i < k; i++) {
      numbers.offer(nums[i]);
    }
    results[0] = numbers.peek();
    for (int i = k; i < nums.length; i++) {
      for (int num : numbers) {
        if (num == nums[i - k]) {
          numbers.remove(num);
          break;
        }
      }
      numbers.offer(nums[i]);
      results[i - k + 1] = numbers.peek();
    }
    return results;
  }
}
