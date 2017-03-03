public class Solution {
  public List<Interval> merge(List<Interval> intervals) {
    
  }

  private void sort(List<Interval> intervals, int low, int high) {
    if(low < high) {
      q = partition(intervals, low, high);
      sort(intervals, low, q-1);
      sort(intervals, q+1, high);
    }
    return; 
  }

  private void partition(List<Interval> intervals, int low, int high) {
    
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
