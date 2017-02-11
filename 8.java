public class Solution {
  public int myAtoi(String str) {
    long integer = 0;
    int sign = 1;
    if(str == null) {
      return 0;
    }
    str = str.trim();
    if(str.length() == 0) {
      return 0;
    }
    if(str.charAt(0) == '+' || str.charAt(0) == '-') {
      sign = (str.charAt(0) == '+') ? 1 : -1;
      str = str.substring(1, str.length());
    }
    for(int i = 0; i < str.length(); i++) {
      if(str.charAt(i) < '0' || str.charAt(i) > '9') {
        return (int) integer * sign;
      }
      integer = integer * 10 + (str.charAt(i) - '0');
      if(sign == 1 && integer > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }
      if(sign == -1 && -integer < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      } 
    }
    return (int) integer * sign; 
  }
}
