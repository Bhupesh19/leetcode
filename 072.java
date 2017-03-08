public class Solution {
  public int minDistance(String word1, String word2) {
    int[][] md = new int[word1.length()+1][word2.length()+1];
    for(int i = 0; i <= word1.length(); i++) {
      md[i][0] = i;  
    }
    for(int j = 0; j <= word2.length(); j++) {
      md[0][j] = j;  
    }
    for(int i = 1; i <= word1.length(); i++) {
      for(int j = 1; j <= word2.length(); j++) {
        if(word1.charAt(i-1) == word2.charAt(j-1)) {
          md[i][j] = md[i-1][j-1];
        } else if(md[i-1][j] >= md[i][j-1] && md[i-1][j-1] >= md[i][j-1]) {
          md[i][j] = md[i][j-1] + 1;
        } else if(md[i][j-1] >= md[i-1][j] && md[i-1][j-1] >= md[i-1][j]){
          md[i][j] = md[i-1][j] + 1;
        } else {
          md[i][j] = md[i-1][j-1] + 1;
        }
      }
    }
    return md[word1.length()][word2.length()];
  }
}
