public class Solution {
  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> map1 = new HashMap<>();
    Map<Character, Character> map2 = new HashMap<>();
    for(int i = 0; i < s.length(); i++) {
      char sc = s.charAt(i), tc = t.charAt(i);
      if(map1.containsKey(sc) && map1.get(sc) != tc || map2.containsKey(tc) && map2.get(tc) != sc) {
        return false;
      }
      map1.put(sc, tc);
      map2.put(tc, sc);
    }
    return true;
  }
}
