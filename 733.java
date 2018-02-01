class Solution {
    
  private int origin;
  private int[][] results;

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    origin = image[sr][sc];
    results = image;
    flood(sr, sc);
    for (int i = 0; i < results.length; i++) {
      for (int j = 0; j < results[0].length; j++) {
        if (results[i][j] == 65536) {
          results[i][j] = newColor;
        }
      }
    }
    return results;
  }
    
  private void flood(int r, int c) {
    if (r < 0 || r >= results.length || c < 0 || c >= results[0].length) return;
    if (results[r][c] == origin) {
      results[r][c] = 65536;
      flood(r - 1, c);
      flood(r + 1, c);
      flood(r, c - 1);
      flood(r, c + 1);
    }
  }
}
