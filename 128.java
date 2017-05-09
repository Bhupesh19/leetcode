public class Solution {
  public int longestConsecutive(int[] nums) {
    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for(int num : nums) {
      if(!map.containsKey(num)) {
        int left = 0, right = 0;
        if(map.containsKey(num - 1)) { 
          left = map.get(num - 1);
        }
        if(map.containsKey(num + 1)) {
          right = map.get(num + 1);
        }
        int sum = left + right + 1;
        map.put(num, sum);
        res = (res > sum) ? res : sum;
        map.put(num - left, sum);
        map.put(num + right, sum);
      }
    }
    return res;
  }
}
