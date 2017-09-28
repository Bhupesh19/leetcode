class Solution {
  public boolean checkValidString(String s) {
    return check(s, 0, 0);  
  }

  private boolean check(String s, int level, int counter) {
    if(counter < 0) {
      return false;
    }
    if(level == s.length()) {
      return counter == 0;
    }
    if(s.charAt(level) == '(') {
      counter++;
      return check(s, level + 1, counter);
    } else if(s.charAt(level) == ')') {
      counter--;
       return check(s, level + 1, counter);
    } else {
      return check(s, level + 1, counter + 1) || check(s, level + 1, counter) || check(s, level + 1, counter - 1); 
    }
  }
}
