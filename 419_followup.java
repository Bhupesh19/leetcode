class Solution {
  public int countBattleships(char[][] board) {
    int rn = board.length;
    int cn = board[0].length;
    int counts = 0;
    for (int m = 0; m < rn; m++) {
      for (int n = 0; n < cn; n++) {
        if (board[m][n] == 'X') {
            if (m - 1 >= 0 && board[m - 1][n] == 'X' || n - 1 >= 0 && board[m][n - 1] == 'X') {
                continue;
            }
            counts++;
        }
      }
    }
    return counts;
  }
}
