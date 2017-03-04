public class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    if(matrix.length == 0) {
      return res;
    }
    int x = 0, row = matrix.length;
    int y = 0, col = matrix[0].length;
    while(x < row || y < col) {
      int i = x; 
      int j = y;
      for(; j < col && i < row; j++) {
        res.add(matrix[i][j]);
      }
      i++;
      j--;
      for(; i < row && j < col; i++) {
        res.add(matrix[i][j]);
      }
      i--;
      j--;
      for(; j >= y && i >= x; j--) {
        res.add(matrix[i][j]);
      }
      i--;
      j++;
      for(; i >= x+1 && j >= y ; i--) {
        res.add(matrix[i][j]);
      }
      row--;
      col--;
      x++;
      y++;
    }
    return res;
  }
}
