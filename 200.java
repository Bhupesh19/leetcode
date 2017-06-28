public class Solution {
  
  private boolean[][] visited;
  private int counter = 0;

  public int numIslands(char[][] grid) {
    if(grid.length <= 0) {
      return 0;
    }
    int m = grid.length, n = grid[0].length;
    visited = new boolean[m][n];
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(grid[i][j] == '1' && !visited[i][j]) {
          dfs(grid, i, j);
          counter++;
        }
        visited[i][j] = true;
      }
    }
    return counter;
  }
  
  private void dfs(char[][] grid, int i, int j) {
    if(grid[i][j] == '0') {
      return;
    }
    visited[i][j] = true;
    if(i - 1 >= 0 && !visited[i - 1][j]) {
      dfs(grid, i - 1, j);
    }
    if(j - 1 >= 0 && !visited[i][j - 1]) {
      dfs(grid, i, j - 1); 
    }
    if(i + 1 < grid.length && !visited[i + 1][j]) {
      dfs(grid, i + 1, j);
    }
    if(j + 1 < grid[0].length && !visited[i][j + 1]) {
      dfs(grid, i, j + 1);
    }
  }
}
