public class Solution {
  public String minWindow(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    for(int i = 0; i < t.length(); i++) {
      if(!map.containsKey(t.charAt(i))) {
        map.put(t.charAt(i), 1);
      } else {
        map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
      }
    }
    int begin = 0, end = 0, head = 0;
    int min = Integer.MAX_VALUE;
    int counter = t.length();
    while(end < s.length()) {
      if(map.containsKey(s.charAt(end)) && map.get(s.charAt(end)) > 0) {
        counter--;
      } 
      if(map.containsKey(s.charAt(end))) {
        map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
      }
      end++;
      while(counter == 0) {
        if(min > end - begin) {
          min = end - begin;
          head = begin;
        }
        if(map.containsKey(s.charAt(begin)) && map.get(s.charAt(begin)) == 0) {
          counter++;
        }
        if(map.containsKey(s.charAt(begin))) {
          map.put(s.charAt(begin), map.get(s.charAt(begin)) + 1);
        }
        begin++;
      }
    }
    return (min == Integer.MAX_VALUE) ? "" : s.substring(head, head+min);
  }
}
