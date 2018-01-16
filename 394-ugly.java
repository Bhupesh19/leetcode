class Solution {
  public String decodeString(String s) {
    Stack<String> stk = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch >= '0' && ch <= '9') {
        StringBuilder temp = new StringBuilder();
        while (ch >= '0' && ch <= '9') {
          temp.append(ch);
          i++;
          ch = s.charAt(i);
        }
        stk.push(temp.toString());
        stk.push("[");
      } else if (ch != ']') {
        stk.push(String.valueOf(ch));
      } else {
        StringBuilder sb = new StringBuilder();
        StringBuilder st = new StringBuilder();
        while (!stk.isEmpty()) {
          if (!stk.peek().equals("[")) {
            sb.insert(0, stk.pop());
          } else {
            stk.pop();
            int times = Integer.valueOf(stk.pop());
            for (int j = 0; j < times; j++) {
              st.append(sb);
            }
            break;
          }
        }
        stk.push(st.toString());
      }
    }
    StringBuilder res = new StringBuilder();
    while (!stk.isEmpty()) {
      res.insert(0, stk.pop());
    }
    return res.toString();
  }
}
