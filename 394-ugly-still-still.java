class Solution {
  public String decodeString(String s) {
    Stack<String> stk = new Stack<>();
    int i = 0;
    while (i < s.length()) {
      if (Character.isDigit(s.charAt(i))) {
        int start = i;
        while (Character.isDigit(s.charAt(i))) {
          i++;
        }
        stk.push(s.substring(start, i));
        stk.push("[");
        i++;
      } else if (s.charAt(i) != ']') {
        int start = i;
        while (i < s.length() && Character.isLetter(s.charAt(i))) {
          i++;
        }
        stk.push(s.substring(start, i));
      } else {
        StringBuilder sbase = new StringBuilder();
        while (!stk.peek().equals("[")) {
          sbase.insert(0, stk.pop());
        }
        stk.pop();
        int times = Integer.valueOf(stk.pop());
        String st = String.join("", Collections.nCopies(times, sbase));
        stk.push(st);
        i++;
      }
    }
    StringBuilder res = new StringBuilder();
    while (!stk.isEmpty()) {
        res.insert(0, stk.pop());
    }
    return res.toString();
  }
}
