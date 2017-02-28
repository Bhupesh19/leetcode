public class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> results = new ArrayList<>();
    if(n == 0) {
      return results;
    }
    int[] board = new int[n];
    for(int i = 0; i < n; i++) {
      board[i] = -1;
    }
    Set<Integer> colUsed = new HashSet<>();
    nQueens(results, colUsed, board, n, 0); 
    return results;
  }

  private void nQueens(List<List<String>> results, Set<Integer> colUsed, int[] board, int n, int row) {
    if(row == n) {
      List<String> solution = new ArrayList<>();
      for(int i = 0; i < n; i++) {
        StringBuilder str = new StringBuilder("");
        for(int j = 0; j < n; j++) {
          if(board[i] != j) {
            str.append('.');
          } else {
            str.append('Q');
          }
        }
        solution.add(str.toString());    
      }
      results.add(solution);
      return;
    }
    for(int i = 0; i < n; i++) {
      if(row == 0 || (Math.abs(board[row-1]-i) > 1 && !colUsed.contains(i) && row != i && )) {
        board[row] = i;
        colUsed.add(i);
        nQueens(results, colUsed, board, n, row+1);
        board[row] = -1;
        colUsed.remove(i);
      } 
    }  
  }
}
