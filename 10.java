public class Solution {
  public boolean isMatch(String s, String p) {
    if(p == null || s == null) {
      return false;
    }
    if(s.equals(p)) {
      return true;
    }
    if(p.length() == 0 || p.charAt(0) == '*') {
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
    int j = 0;
    for(int i = 0; i < s.length(); i++) {
      if(s.charAt(i) != p.charAt(j) && p.charAt(j) != '.') {
        if(!map.containsKey(j)) {
          return false;
        } 
        while(j < p.length()-1) {
          if(map.get(j) == s.charAt(i)) {
            break;
          }
          j += 2;
        }
        if(j == p.length()) {
        }
      } 
    }    
  }
}
