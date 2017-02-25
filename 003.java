public class Solution {
  public int lengthOfLongestSubstring(String s) {
    char[] sarr = s.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    int max = 0;
    int start = 0;
    for(int i = 0; i < sarr.length; i++) {
      if(map.containsKey(sarr[i])) {
        start = (start > map.get(sarr[i])) ? start : map.get(sarr[i]) + 1;
      }
      map.put(sarr[i], i);
      max = (max > i - start + 1) ? max : i - start + 1; 
    }
    return max;
  }
}
