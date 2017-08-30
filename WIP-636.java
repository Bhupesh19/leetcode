class Solution {
  public int[] exclusiveTime(int n, List<String> logs) {
    int interval = 0;
    Stack<String> stk = new Stack<>();
    int[] res = new int[n];
    for(String log: logs) {
      if(log.indexOf("start") != -1) {
        stk.push(log);
      }
      if(log.indexOf("end") != -1) {
        String[] stime = (stk.pop()).split(":");
        String[] etime = log.split(":");
        int st = Integer.parseInt(stime[2]);
        int et = Integer.parseInt(etime[2]); 
        res[Integer.parseInt(stime[0])] += et - st + 1 - interval; 
        interval = et - st + 1;
      }
    }
    return res;
  }
}
