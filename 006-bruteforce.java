public class Solution {
  public String convert(String s, int numRows) {
    if(numRows == 1 || numRows >= s.length()) {
      return s;
    }
    StringBuilder[] strArray = new StringBuilder[numRows];
    for(int i = 0; i < numRows; i++) {
      strArray[i] = new StringBuilder("");
    }
    int j = 0;
    boolean down = false;
    for(int i = 0; i < s.length(); i++) {
      strArray[j].append(s.charAt(i));
      if(j == 0 || j == numRows - 1) {
        down = !down;
      }
      j = (down) ? j + 1 : j - 1;
    }
    return String.join("", strArray); 
  }
}
