public class Solution {
  public String addBinary(String a, String b) {
    int i = a.length() - 1, j = b.length() - 1;
    int c = 0;
    StringBuilder str = new StringBuilder("");
    while(i >= 0 || j >= 0) {
      int sum = 0;
      if(i >= 0) {
        sum += a.charAt(i--) - '0';
      }
      if(j >= 0) {
        sum += b.charAt(j--) - '0';
      }
      sum += c;
      str.append(sum%2);
      c = sum / 2;
    }
    if(c == 1) {
      str.append(1);
    }
    return str.reverse().toString();
  }
}
