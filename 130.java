public class Solution {

  public void solve(char[][] board) {
    if(board.length == 0 || board[0].length == 0 || board.length == 1 || board[0].length == 1) {
      return;
    }
    int r = board.length, c = board[0].length;
    for(int i = 0; i < c; i++) {
      mark(board, 0, i);
      mark(board, r - 1, i);  
    }
    for(int i = 1; i < r - 1; i++) {
      mark(board, i, 0);
      mark(board, i, c - 1);
    }
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        if(board[i][j] == 'K') {
          board[i][j] = 'O'; 
        } else if(board[i][j] == 'O'){
          board[i][j] = 'X';
        }
      }
    }
    return;
  }

  private void mark(char[][] board, int i, int j) {
    if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
      return;
    }
    if(board[i][j] == 'O') {
      board[i][j] = 'K';
      if(i > 1) { 
        mark(board, i - 1, j);
      }
      if(j > 1) {
        mark(board, i, j - 1);
      }
      if(i + 1 < board.length - 1) { 
        mark(board, i + 1, j);
      }
      if(j + 1 < board[0].length - 1) {
        mark(board, i, j + 1);
      }
    }
  }
}
