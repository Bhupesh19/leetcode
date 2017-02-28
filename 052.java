public class Solution {
  
  int results = 0;
  
  public int totalNQueens(int n) {
    int[] board = new int[n];
    for(int i = 0; i < n; i++) {
      board[i] = -1;
    }
    Set<Integer> colUsed = new HashSet<>();
    Set<Integer> firstDiaUsed = new HashSet<>(); 
    Set<Integer> secondDiaUsed = new HashSet<>();
    nQueens(colUsed, firstDiaUsed, secondDiaUsed, board, n, 0); 
    return results;
  }

  private void nQueens(Set<Integer> colUsed, Set<Integer> firstDiaUsed, Set<Integer> secondDiaUsed, int[] board, int n, int row) {
    if(row == n) {
      results++;
      return;
    }
    for(int i = 0; i < n; i++) {
      if(row == 0 || (!colUsed.contains(i) && !firstDiaUsed.contains(i-row) &&  !secondDiaUsed.contains(i+row))) {
        board[row] = i;
        colUsed.add(i);
        firstDiaUsed.add(i-row);
        secondDiaUsed.add(i+row);
        nQueens(colUsed, firstDiaUsed, secondDiaUsed, board, n, row+1);
        board[row] = -1;
        colUsed.remove(i);
        firstDiaUsed.remove(i-row);
        secondDiaUsed.remove(i+row);
      } 
    }  
  }
}
