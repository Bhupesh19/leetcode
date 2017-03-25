public class Solution {
  public int largestRectangleArea(int[] heights) {
    //traverse the whole array, find rectangle areas which start from the current histogram
    int maxArea = 0;
    for(int i = 0; i < heights.length; i++) {
      int height = heights[i];
      maxArea = (maxArea > height) ? maxArea : height;
      for(int j = i+1; j < heights.length; j++) {
        height = (height < heights[j]) ? height : heights[j];
        maxArea = (maxArea > height * (j - i + 1)) ? maxArea : height * (j - i + 1);
      }
    }
    return maxArea;
  }
}
