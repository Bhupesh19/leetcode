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
    return layerMatch(s, p, 0, 0);
  }

  public boolean islayerMatch(String s, String p, int level, int index) {
    if(level == p.length()+1) {
      return index == s.length();
    }
    if(!map.containsKey(p.charAt(level))) {
      if(s.charAt(index) != p.charAt(level) && p.charAt(level) != '.') {
        return false;
      }
      return islayerMatch(s, p, level+1, index+1);
    }
    if(p.charAt(level) == s.charAt(index) || p.charAt(level) == '.') {
      return islayerMatch(s, p, level, index+1) || islayerMatch(s, p, level+2, index+1);
    } else {
      return islayerMatch(s, p, level+2, index);
    }   
  }
}
