public class Solution {
  public boolean isValidSudoku(char[][] board) {
    for(int i = 0; i < 9; i++) {
      Set<Character> rowElems = new HashSet<>();
      Set<Character> colElems = new HashSet<>();
      Set<Character> cubElems = new HashSet<>();
      for(int j = 0; j < 9; j++) {
        if(board[i][j] != '.' && !rowElems.add(board[i][j])) {
          return false; 
        }
        if(board[j][i] != '.' && !colElems.add(board[j][i])) {
          return false;
        }
        int rowIndex = 3 * (i / 3);
        int colIndex = 3 * (i % 3);
        if(board[rowIndex+j/3][colIndex+j%3] != '.' && !cubElems.add(board[rowIndex+j/3][colIndex+j%3])) {
          return false;
        }
      }
    }
    return true; 
  }
}
