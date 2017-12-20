class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stk = new Stack<>();
    int[] results = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) {
      while (!stk.isEmpty() && temperatures[stk.peek()] < temperatures[i]) {
        int index = stk.pop();
        results[index] = i - index;
      }
      stk.push(i);
    }
    return results;
  }
}
