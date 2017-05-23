public class Solution {
  public String reverseWords(String s) {
    StringBuilder sb = new StringBuilder("");
    String[] sarr = s.split(" ");
    for(int i = sarr.length - 1; i >= 0; i--) {
      if(!sarr[i].trim().equals("")) {
        sb.append(sarr[i]).append(" ");
      }
    }
    return sb.toString().trim();
  }
}
