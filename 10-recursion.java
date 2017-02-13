public class Solution {
  private Set<Integer> indexSet = new HashSet<>();
  
  public boolean isMatch(String s, String p) {
    if(p == null || s == null) { 
      return false;
    }
    if (p.length() == 0) {
      return s.length() == 0;
    }
    if (p.charAt(0) == '*') {
      return false;
    }
    for(int i = 1; i < p.length(); i++) {
      if(p.charAt(i) == '*') {
        if(p.charAt(i-1) == '*') {
          return false;
        } 
        indexSet.add(i-1);
      }
    }
    return isLayerMatch(s, p, 0, 0);
  }

  private boolean isLayerMatch(String s, String p, int level, int index) {
    if(level == p.length()) {
      return index == s.length();
    }
    if(index == s.length()) {
      while(level < p.length()) {
        if(!indexSet.contains(level)) {
          return false;
        }
        level += 2;  
      }
      return true; 
    }
    if(!indexSet.contains(level)) {
      if(!isCharMatch(s.charAt(index), p.charAt(level))) {
        return false;
      }
      return isLayerMatch(s, p, level+1, index+1);
    }
    if(isCharMatch(s.charAt(index), p.charAt(level))) {
      return isLayerMatch(s, p, level, index+1) || isLayerMatch(s, p, level+2, index+1) || isLayerMatch(s, p, level+2, index);
    } else {
      return isLayerMatch(s, p, level+2, index);
    }
  }
  
  private boolean isCharMatch(char c1, char c2) {
    return c1 == c2 || c2 == '.';
  } 
}
