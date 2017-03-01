public class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int rows = obstacleGrid.length;
    int cols = obstacleGrid[0].length;
    int[][] paths = new int[rows][cols];
    for(int i = 0; i < rows; i++) {
      if(obstacleGrid[i][0] == 0) {
        paths[i][0] = 1;     
      } else {
        break;
      }
    } 
    for(int i = 0; i < cols; i++) {
      if(obstacleGrid[0][i] == 0) {
        paths[0][i] = 1;     
      } else {
        break;
      }
    }
    for(int i = 1; i < rows; i++) {
      for(int j = 1; j < cols; j++) {
        if(obstacleGrid[i][j] == 0) {
          paths[i][j] = paths[i-1][j] + paths[i][j-1];
        } else {
          paths[i][j] = 0;
        }
      }
    }
    return paths[rows-1][cols-1]; 
  }
}
