class Solution {
  public int findMinDifference(List<String> timePoints) {
    int diff = Integer.MAX_VALUE;
    int[] times = new int[timePoints.size()];
    for (int i = 0; i < timePoints.size(); i++) {
      int hour = Integer.parseInt(timePoints.get(i).substring(0, 2));
      int min = Integer.parseInt(timePoints.get(i).substring(3, 5));
      times[i] = hour * 60 + min;
    }
    Arrays.sort(times);
    for (int i = 0; i < times.length - 1; i++) {
      diff = Math.min(diff, times[i + 1] - times[i]);
    }
    diff = Math.min(diff, times[0] + 1440 - times[times.length - 1]);
    return diff;
  }
}
