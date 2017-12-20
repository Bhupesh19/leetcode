class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Stack<Integer> stk = new Stack<>();
    int[] results = new int[nums1.length];
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums2) {
      while (!stk.isEmpty() && stk.peek() < num) {
        int temp = stk.pop();
        map.put(temp, num); 
      }
      stk.push(num);
    }
    for (int i = 0; i < nums1.length; i++) {
      if(map.containsKey(nums1[i])) {
        results[i] = map.get(nums1[i]);
      } else {
        results[i] = -1;
      } 
    }
    return results;
  }
}
