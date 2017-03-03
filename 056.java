public class Solution {
  public List<Interval> merge(List<Interval> intervals) {
    sort(intervals, 0, intervals.size()-1); 
    List<Interval> results = new ArrayList<>();
    if(intervals.size() == 0) {
      return results;
    }
    results.add(intervals.get(0));
    for(int i = 1; i < intervals.size(); i++) {
      Interval last = results.get(results.size()-1);
      Interval curr = intervals.get(i);
      if(curr.start > last.end) {
        results.add(curr);
      } else {
        last.start = (last.start < curr.start) ? last.start : curr.start;
        last.end = (last.end > curr.end) ? last.end : curr.end;
      }
    }
    return results; 
  }

  private void sort(List<Interval> intervals, int low, int high) {
    if(low < high) {
      int q = partition(intervals, low, high);
      sort(intervals, low, q-1);
      sort(intervals, q+1, high);
    }
    return; 
  }

  private int partition(List<Interval> intervals, int low, int high) {
    Interval pivot = intervals.get(high);
    int j = low;
    for(int i = low; i < high; i++) {
      if(intervals.get(i).start <= pivot.start) {
        swap(intervals, i, j);
        j++;
      }
    }
    swap(intervals, j, high);
    return j; 
  }

  private void swap(List<Interval> intervals, int fst, int snd) {
    int temp = intervals.get(fst).start;
    intervals.get(fst).start = intervals.get(snd).start;
    intervals.get(snd).start = temp;
    temp = intervals.get(fst).end;
    intervals.get(fst).end = intervals.get(snd).end;
    intervals.get(snd).end = temp;
    return;
  } 
}
