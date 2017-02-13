public class Solution {
  private Map<Integer, Character> map = new HashMap<>();
  
  public boolean isMatch(String s, String p) {
    if(p == null || s == null || p.length() == 0 || p.charAt(0) == '*') {
      return false;
    }
    for(int i = 1; i < p.length(); i++) {
      if(p.charAt(i) == '*') {
        if(p.charAt(i-1) == '*') {
          return false;
        }
        map.put(i-1, p.charAt(i-1));
      }
    }
    return isLayerMatch(s, p, 0, 0);
  }

  public boolean isLayerMatch(String s, String p, int level, int index) {
    if(level == p.length()) {
      return index == s.length();
    }
    if(index == s.length()) {
      if(level != p.length()) {
        while(level < p.length()) {
          if(!map.containsKey(level)) {
            return false;
          }
          level += 2;  
        }
      }
      return true; 
    }
    if(!map.containsKey(p.charAt(level))) {
      if(s.charAt(index) != p.charAt(level) && p.charAt(level) != '.') {
        return false;
      }
      return isLayerMatch(s, p, level+1, index+1);
    }
    if(p.charAt(level) == s.charAt(index) || p.charAt(level) == '.') {
      return isLayerMatch(s, p, level, index+1) || isLayerMatch(s, p, level+2, index+1) || isLayerMatch(s, p, level+2, index);
    } else {
      return isLayerMatch(s, p, level+2, index);
    }
  }
}
