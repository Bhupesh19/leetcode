public class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> m = new HashMap<>();
    for(int i = 0; i < magazine.length(); i++) {
      if(!m.containsKey(magazine.charAt(i))) {
        m.put(magazine.charAt(i), 1);
      } else {
        m.put(magazine.charAt(i), m.get(magazine.charAt(i)) + 1);
      }
    }
    for(int i = 0; i < ransomNote.length(); i++) {
      if(!m.containsKey(ransomNote.charAt(i))) {
        return false;
      }
      m.put(ransomNote.charAt(i), m.get(ransomNote.charAt(i)) - 1);
      if(m.get(ransomNote.charAt(i)) < 0) {
        return false; 
      }
    }
    return true;
  }
}
