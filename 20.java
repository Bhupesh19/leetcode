public class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for(int i = 0; i < s.length(); i++) {
      if(isLeft(s.charAt(i))) {
        stack.push(s.charAt(i));
      } else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(') {
        stack.pop();
      } else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[') {
        stack.pop();
      } else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{') {
        stack.pop();
      } else {
        return false;
      }
    }
    return stack.empty();
  }

  private boolean isLeft(char c) {
    return "([{".indexOf(c) != -1;
  }
}
