public class Solution {
  public int numDistinct(String s, String t) {
    int[][] p = new int[t.length()+1][s.length()+1];
    for(int j = 0; j < s.length(); j++) {
      p[0][j] = 1;
    }
    for(int i = 0; i < t.length(); i++) {
      for(int j = 0; j < s.length(); j++) {
        if(s.charAt(j) == t.charAt(i)) {
          p[i+1][j+1] = p[i+1][j] + p[i][j];
        } else {
          p[i+1][j+1] = p[i+1][j]; 
        }
      }
    }
    return p[t.length()][s.length()];
  }
}
