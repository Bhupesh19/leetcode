public class MinStack {
  
  private Stack<Integer> stk;
  private Stack<Integer> minStk = new Stack<>();
  
  public MinStack() {
    stk = new Stack<Integer>();
  }
  
  public void push(int x) {
    stk.push(x);
    if(!minStk.isEmpty() && minStk.peek() < x) {
      minStk.push(minStk.peek());
    } else {
      minStk.push(x);
    }
  }

  public void pop() {
    stk.pop();
    minStk.pop(); 
  }

  public int top() {
    return stk.peek(); 
  }

  public int getMin() {
    return minStk.peek();
  }
}
