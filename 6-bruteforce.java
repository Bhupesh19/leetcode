public class Solution {
  public String convert(String s, int numRows) {
    if(numRows == 1 || numRows > s.length()) {
      return s;
    }
    StringBuilder[] strArray = new StringBuilder[numRows];
    int j = 0;
    boolean down = true;
    for(int i = 0; i < s.length(); i++) {
      strArray[j].append(s.charAt(i));
      if(j == numRows - 1) {
        down = false;
      }
      if(j == 0) {
        down = true;
      }
      if(down) {
        j++;
      } else {
        j--;
      }
    }
    String str = "";
    for(int i = 0; i < numRows; i++) {
      str += strArray[i];
    }
    return str; 
  }
}
