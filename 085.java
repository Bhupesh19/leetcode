public class Solution {
  public int maximalRectangle(char[][] matrix) {
    if(matrix.length == 0) {
      return 0;
    }
    int rows = matrix.length;
    int cols = matrix[0].length;
    int maxArea = 0;
    int[][] ones = new int[rows][cols];
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < cols; j++) {
        if(matrix[i][j] == '1') {
          if(j > 0) {
            ones[i][j] = ones[i][j-1] + 1;
          } else {
            ones[i][j] = 1;
          }
        } else {
          if(j > 0) {
            ones[i][j] = ones[i][j-1]; 
          }
        }
      }
    }
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < cols; j++) {
        //calculate all rectangles' areas which use matrix[i][j] as the left top point
        if(matrix[i][j] == '1') {
          int width = 1;
          for(int k = j + 1; k < cols; k++) {
            if(matrix[i][k] == '0') {
              break;
            }
            width++;
          }
          maxArea = (maxArea > width) ? maxArea : width;
          for(int m = i + 1; m < rows; m++) {
            if(width > 0) {
              for(int n = j + width - 1; n >= j; n--) {
                if((j == 0 && ones[m][n] == n + 1) || (j > 0 && ones[m][n] - ones[m][j-1] == n - j + 1)) {
                  break;
                } 
                width--;
              }
              maxArea = (maxArea > width * (m - i + 1)) ? maxArea : width * (m - i + 1);
            }
          }
        }
      }
    }
    return maxArea;
  }
}
