public class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0) {
      return false;
    }
    int rows = matrix.length, cols = matrix[0].length;
    int low = 0, high = rows * cols - 1;
    while(low <= high) {
      int mid = (low + high) / 2;
      int midVal = matrix[mid/cols][mid%cols];
      if(target < midVal) {
        high = mid - 1;
      } else if (target > midVal) {
        low = mid + 1;
      } else {
        return true;
      }
    }
    return false; 
  }
}
