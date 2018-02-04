class Solution {
  public int eraseOverlapIntervals(Interval[] intervals) {
    if (intervals.length == 0) {
      return 0;
    }
    Arrays.sort(intervals, (a, b) -> a.end - b.end);
    int end = intervals[0].end;
    int count = 0;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i].start < end) {
        count++;
      } else {
        end = intervals[i].end;
      }
    }
    return count;
  }
}
