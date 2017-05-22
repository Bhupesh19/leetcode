public class Solution {
  public int evalRPN(String[] tokens) {
    Stack<Integer> nums = new Stack<>();
    int res = 0;
    String ops = "+-*/";
    for(String token : tokens) {
      if(ops.indexOf(token) != -1) {
        int num2 = nums.pop();
        int num1 = nums.pop();
        res = cal(token, num1, num2);
        nums.push(res); 
      } else {
        nums.push(Integer.parseInt(token));
      }
    }
    return nums.pop();
  }

  private int cal(String op, int num1, int num2) {
    switch(op) {
      case "+":
        return num1 + num2;
      case "-":
        return num1 - num2;
      case "*":
        return num1 * num2;
      case "/":
        return num1 / num2;
    }
    return 0;
  }
}
