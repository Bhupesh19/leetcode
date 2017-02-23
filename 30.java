public class Soluiton {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> results = new ArrayList<>();
    if(words.length == 0) {
      return results;
    }
    int wl = words[0].length();
    if(wl == 0) {
      for(int i = 0; i < s.length(); i++) {
        results.add(i);
      }
      return results;
    }
    Map<String, Integer> map = new HashMap<>();
    for(String word : words) {
      if(map.containsKey(word)) {
        map.put(word, map.get(word)+1);
      } else {
        map.put(word, 1);
      }
    }
    return results;
  }
}
