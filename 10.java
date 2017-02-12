public class Solution {
  public boolean isMatch(String s, String p) {
    if(p == null || s == null || p.length() == 0 || p.charAt(0) == '*') {
      return false;
    }
    Map<Integer, Character> map = new HashMap<>();
    for(int i = 1; i < p.length(); i++) {
      if(p.charAt(i) == '*') {
        if(p.charAt(i-1) == '*') {
          return false;
        }
        map.put(i-1, p.charAt(i-1));
      }
    }
    int i = 0, j = 0;
  }
}
