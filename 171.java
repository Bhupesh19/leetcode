public class Solution {
  public int titleToNumber(String s) {
    int num = 0;
    for(int i = s.length() - 1; i >= 0; i--) {
      int bit = s.length() - 1 - i;
      num += (s.charAt(i) - 'A' + 1) * Math.pow(26, bit); 
    }
    return num;
  }
}
