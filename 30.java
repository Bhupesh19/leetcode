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
    Set<Integer> rset = new HashSet<>();
    Map<String, Integer> map = new HashMap<>();
    for(String word : words) {
      if(map.containsKey(word)) {
        map.put(word, map.get(word)+1);
      } else {
        map.put(word, 1);
      }
    }
    for(int i = 0; i+wl-1 < s.length(); i++) {
      if(s.substring(i, i+wl).equals(words[0])){
        extend(s, map, wl, i, rset);
      }
    }
    for(Integer index : rset) {
      results.add(index);
    }
    return results;
  }

  private void extend(String s, Map<String, Integer> map, int wl, int index, Set<Integer> rset) {
    Map<String, Integer> tempMap = new HashMap<>(map);
    int 
    for(int i = index; i >= 0; i -= wl) {
      String pattern = s.substring(i, i+wl);
      if(tempMap.containsKey(pattern)) {
        tempMap.put(pattern, tempMap.get()-1);
      }
    }  
  }
}
