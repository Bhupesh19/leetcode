public class Solution {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    intervals.add(newInterval);
    intervals.sort((i1, i2) -> Integer.compare(i1.end, i2.end));
    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
    Set<Integer> index = new HashSet<>();
    int i = 0;
    for(i = 0; i < intervals.size(); i++) {
      Interval curr = intervals.get(i);
      if(curr.start == newInterval.start && curr.end == newInterval.end) {
        break; 
      }
    }
    Interval prev = new Interval();
    if(i < intervals.size()) { 
      prev = intervals.get(i);
    }
    for(int j = i - 1; j >= 0; j--) {
      Interval pprv = intervals.get(j);
      if(pprv.end < prev.start) {
        break;
      }
      prev.start = (pprv.start < prev.start) ? pprv.start : prev.start;
      prev.end = (pprv.end > prev.end) ? pprv.end : prev.end;
      index.add(j);
    }
    for(int j = i + 1; j < intervals.size(); j++) {
      Interval curr = intervals.get(j);
      if(prev.end < curr.start) {
        break;
      }
      prev.start = (prev.start < curr.start) ? prev.start : curr.start;
      prev.end = (prev.end > curr.end) ? prev.end : curr.end;
      index.add(j);
    }
    List<Interval> res = new ArrayList<>(); 
    for(int k = 0; k < intervals.size(); k++) {
      if(!index.contains(k)) {
        res.add(intervals.get(k));
      }
    }
    return res;
  }
}
