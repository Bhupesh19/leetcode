public class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
    Map<String, Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder(s);
    for(int i = 0; i < s.length() - 9; i++) {
      String ss = sb.substring(i, i + 10);
      if(!map.containsKey(ss)) {
        map.put(ss, 1); 
      } else {
        map.put(ss, map.get(ss) + 1);
      }
    }
    List<String> res = new ArrayList<>();
    for(String key : map.keySet()) {
      if(map.get(key) > 1) {
        res.add(key);
      }
    }
    return res;
  }
}
