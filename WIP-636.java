class Solution {
  public int[] exclusiveTime(int n, List<String> logs) {
    int prev = 0;
    Stack<String> stk = new Stack<>();
    int[] res = new int[n];
    for(String log: logs) {
      String[] time = log.split(":");
      if(time[1] == "start") {
        stk.push(log);
      }
      if(time[1] == "end") {

      }
    }
    return res;
  }
}
