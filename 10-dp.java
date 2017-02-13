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
    boolean[][] m = new boolean[s.length()][p.length()];
  }

  
  private boolean isCharMatch(char c1, char c2) {
    return c1 == c2 || c2 == '.';
  } 
}
