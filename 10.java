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
    for(i = 0; i < s.length(); i++) {
      if(s.charAt(i) != p.charAt(j) && p.charAt(j) != '.') {
        if(!map.containsKey(j)) {
          return false;
        } 
        while(j < p.length()) {
          if(map.containsKey(j)) {
            if(s.charAt(i) == p.charAt(j)) {
              break;
            }
            j += 2;
          } else {
            if(s.charAt(i) != p.charAt(j)) {
              return false;
            } 
            j++;
            break;
          }
        }
        if(j >= p.length() && i < s.length()) {
          return false;
        }
      } else {
        j++;
        if(j == p.length()) {
          break;
        }
      }
    }
    return i == s.length();   
  }
}
