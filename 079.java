public class Solution {
  public boolean exist(char[][] board, String word) {
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        if(searchWord(word, 0, board, i, j)) {
          return true;
        } 
      }
    }
    return false;
  }

  private boolean searchWord(String word, int level, char[][] board, int x, int y) {
    if(level == word.length()) {
      return true;
    }
    if(x < 0 || y < 0 || x == board.length || y == board[0].length) {
      return false;
    }
    if(board[x][y] != word.charAt(level)) {
      return false;
    }
    char temp = board[x][y];
    board[x][y] = '-';
    boolean exist = searchWord(word, level+1, board, x, y-1)
            || searchWord(word, level+1, board, x, y+1)
            || searchWord(word, level+1, board, x-1, y)
            || searchWord(word, level+1, board, x+1, y);
    board[x][y] = temp;
    return exist; 
  } 
}
