public class Solution {
  public String countAndSay(int n) {
    StringBuilder seq = new StringBuilder("");
    String str = Integer.toString(1);
    for(int i = 1; i < n; i++) {
      int counter = 1;
      int j = 1;
      seq.setLength(0);
      for(j = 1; j < str.length(); j++) {
        if(str.charAt(j) == str.charAt(j-1)) {
          counter++;
        } else {
          seq.append(counter).append(str.charAt(j-1));
          counter = 1;
        }
      }
      seq.append(counter).append(str.charAt(j-1));
      str = seq.toString();
    }
    return str; 
  }
}
