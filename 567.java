class Solution {
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    Map<Character, Integer> map = new HashMap<>();
    Set<Character> used = new HashSet<>();
    int m = s1.length();
    int n = s2.length();
    for (int i = 0; i < m; i++) {
      map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
      used.add(s1.charAt(i));
    }
    for (int i = 0; i < m; i++) {
      char ch = s2.charAt(i);
      if (used.contains(ch)) {
        map.put(ch, map.getOrDefault(ch, 0) - 1);
      }
      if (map.containsKey(ch) && map.get(ch) == 0) {
        map.remove(ch);
      }
    }
    if (map.size() == 0) {
      return true;
    }
    for (int i = m; i < n; i++) {
      char c1 = s2.charAt(i - m);
      char c2 = s2.charAt(i);
      if (used.contains(c1)) {
        map.put(c1, map.getOrDefault(c1, 0) + 1);
      }
      if (used.contains(c2)) {
        map.put(c2, map.getOrDefault(c2, 0) - 1);
      }
      if (map.containsKey(c1) && map.get(c1) == 0) {
        map.remove(c1);
      }
      if (map.containsKey(c2) && map.get(c2) == 0) {
        map.remove(c2);
      }
      if (map.size() == 0) {
        return true;
      }
    }
    return false;
  }
}
