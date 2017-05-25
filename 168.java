public class Solution {
  public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder("");
    while(n > 0) {
      int cint = n % 26;
      char c = (char) (cint + 'A' - 1);
      if(cint == 0) {
        c = 'Z';
        n--; 
      }
      sb.insert(0, c);
      n /= 26;
    }
    return sb.toString();
  }
}
