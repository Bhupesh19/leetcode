class Solution {
  public int countBattleships(char[][] board) {
    int rn = board.length;
    int cn = board[0].length;
    int counts = 0;
    for (int m = 0; m < rn; m++) {
      for (int n = 0; n < cn; n++) {
        int i = m, j = n;
        if (board[i][j] == 'X') {
          counts++;
          board[i][j] = 'O';
          if (i + 1 < rn && board[i + 1][j] == 'X') {
            while (i + 1 < rn && board[i + 1][j] == 'X') {
              i++;
              board[i][j] = 'O';
            }
          } else if (j + 1 < cn && board[i][j + 1] == 'X') {
            while (j + 1 < cn && board[i][j + 1] == 'X') {
              j++;
              board[i][j] = 'O';
            }
          }
        }
      }
    }
    return counts;
  }
}
