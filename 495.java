class Solution {
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    if(timeSeries.length == 0) return 0;
    int sum = duration;
    for(int i = 0; i < timeSeries.length - 1; i++) {
      if(timeSeries[i + 1] - timeSeries[i] >= duration) {
        sum += duration;
      } else {
        sum += timeSeries[i + 1] - timeSeries[i];
      }
    }
    return sum;
  }
}
