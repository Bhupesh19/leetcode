public class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> results = new ArrayList<>();
    if(words.length == 0) {
      return results;
    }
    int wl = words[0].length();
    Map<String, Integer> map = new HashMap<>();
    for(String word : words) {
      if(map.containsKey(word)) {
        map.put(word, map.get(word)+1);
      } else {
        map.put(word, 1);
      }
    }
    for(int i = 0; i+wl*words.length <= s.length(); i++) {
      Map<String, Integer> tempMap = new HashMap<>(map);
      int j = 0, k = i;
      for(j = i; j < i+wl*words.length; j += wl) {
        String str = s.substring(j, j+wl);
        if(tempMap.containsKey(str)) {
          tempMap.put(str, tempMap.get(str) - 1);
          if(tempMap.get(str) == 0) {
            tempMap.remove(str);
          }
        } else {
          break;
        }     
      }
      if(tempMap.size() == 0) {
        results.add(k);
      }  
    }
    return results;
  }
}
