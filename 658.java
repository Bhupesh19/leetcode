public class Solution {
  public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
    int low = 0, high = arr.size() - 1;
    while(low < high) {
      int mid = (low + high) / 2;
      if(arr.get(mid) == x) {
        low = mid;
        high = mid;
        break;
      }
      if(arr.get(mid) < x && mid + 1 < arr.size() && arr.get(mid + 1) > x) {
        low = mid;
        high = mid + 1;
        break;
      }
      if(arr.get(mid) < x) {
        low = mid + 1;
      }
      if(arr.get(mid) > x) {
        high = mid - 1;
      }
    }
    List<Integer> res = new ArrayList<>();
    if(high == -1) { 
      for(int i = 0; i < k; i++) {
        res.add(arr.get(i));
      }
      return res;
    }
    if(low == arr.size()) { 
      for(int i = 0; i < k; i++) {
        res.add(arr.get(arr.size() - k + i));
      }
      return res;
    }
    if(low == high) {
      res.add(arr.get(low));
      --low;
      ++high;
      k = k - 1;
    }
    for(int i = 0; i < k; i++) {
      if(low < 0) { res.add(arr.get(high)); ++high; continue; }
      if(high >= arr.size()) { res.add(0, arr.get(low)); --low; continue; }
      if(Math.abs(arr.get(low) - x) <= Math.abs(arr.get(high) - x)) {
        res.add(0, arr.get(low));
        --low;
      } else {
        res.add(arr.get(high));
        ++high;
      }
    }
    return res;
  }
}
