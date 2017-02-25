public class Solution {
  public int romanToInt(String s) {
    int num = 0;
    Map<Character, Integer> map = new HashMap<>();
    initMap(map);
    for(int i = 0; i < s.length()-1; i++) {
      if(map.get(s.charAt(i)) >= map.get(s.charAt(i+1))) {
        num += map.get(s.charAt(i));
      } else {
        num -= map.get(s.charAt(i));
      }
    }
    num += map.get(s.charAt(s.length()-1));
    return num;
  }

  private void initMap(Map<Character, Integer> map) {
    map.put('M', 1000);
    map.put('D', 500);
    map.put('C', 100);
    map.put('L', 50);
    map.put('X', 10);
    map.put('V', 5);
    map.put('I', 1);
  }
}
