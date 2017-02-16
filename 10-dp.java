public class Solution { 
  public boolean isMatch(String s, String p) {
    if(p == null || s == null) { 
      return false;
    }
    boolean[][] m = new boolean[s.length()+1][p.length()+1];
    m[0][0] = true;
    for(int j = 2; j <= p.length(); j += 2) {
      if(p.charAt(j-1) != '*') {
        break;
      }
      m[0][j] = true;
    }
    if(s.length() > 0 && p.length() > 0) {
      m[1][1] = isCharMatch(s.charAt(0), p.charAt(0));
    }
    for(int i = 1; i <= s.length(); i++) {
      for(int j = 2; j <= p.length(); j++) {
        if(p.charAt(j-1) != '*') {
          m[i][j] = m[i-1][j-1] && isCharMatch(s.charAt(i-1), p.charAt(j-1));
        } else {
          m[i][j] = m[i][j-2] || m[i][j-1] || ((isCharMatch(s.charAt(i-1), p.charAt(j-2)) && m[i-1][j]));  
        }  
      }
    }
    return m[s.length()][p.length()]; 
  }

  private boolean isCharMatch(char s, char p) {
    return s == p || p == '.';
  }
}
