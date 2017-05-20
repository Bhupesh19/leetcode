public class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    int max = 0;
    Set<String> words = new HashSet<>();
    for(String word : wordDict) {
      words.add(word);
      max = (word.length() > max) ? word.length() : max;
    }
    boolean[] isBreak = new boolean[s.length() + 1]; 
    for(int i = 1; i < isBreak.length; i++) {
      for(int j = 1; i - j >= 0 && j <= max; j++) {
        if(words.contains(s.substring(i - j, i)) && (i - j == 0 || isBreak[i - j])) {
          isBreak[i] = true;
        }
      }
    }
    return isBreak[s.length()];
  }
}
