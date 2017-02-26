public class Solution {
  public boolean isValidSodoku(char[][] board) {
    for(int i = 0; i < 9; i++) {
      Set<Character> rowElems = new HashSet<>();
      Set<Character> colElems = new HashSet<>();
      Set<Character> cubElems = new HashSet<>();
      for(int j = 0; j < 9; j++) {
        if(char[i][j] != '.' && !rowElems.add(char[i][j])) {
          return false; 
        }
        if(char[j][i] != '.' && !colElems.add(char[j][i])) {
          return false;
        }  
      }
    }
    return true; 
  }
}
