class Solution {
  public int[] nextGreaterElements(int[] nums) {
    Stack<Integer> stk = new Stack<>();
    int[] temp = new int[nums.length * 2];
    int[] results = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      temp[i] = nums[i];
      temp[i + nums.length] = nums[i];
    }
    for (int i = 0; i < temp.length; i++) {
      while(!stk.isEmpty() && temp[stk.peek()] < temp[i]) {
        int index = stk.pop();
        results[index] = temp[i];
      }
      if (i < nums.length) {
        stk.push(i);                
      }
    }
    while (!stk.isEmpty()) {
      int index = stk.pop();
      results[index] = -1;
    }
    return results;
  }
}
