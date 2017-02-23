public class Soluiton {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> results = new ArrayList<>();
    if(words.length == 0) {
      return results;
    }
    if(words[0].length() == 0) {
      for(int i = 0; i < s.length(); i++) {
        results.add(i);
      }
      return results;
    }
     
    return results;
  }

  private void extend(String s, String[] words, int index, Map<String, > map, List<Integer> results) {
  }
  
}
