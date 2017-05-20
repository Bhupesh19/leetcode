public class Solution {

  private List<List<String>> res = new ArrayList<>();

  public List<List<String>> partition(String s) {
    if(s.length() == 0) {
      return res;
    }
    boolean[][] pre = isPalindrome(s);
    List<String> part = new ArrayList<>();
    partitions(s, part, 0, pre);
    return res;
  }

  private void partitions(String s, List<String> part, int next, boolean[][] pre) {
    if(next == s.length()) {
      res.add(new ArrayList<String>(part));
      return;
    }
    for(int i = 0; i < s.length() - next; i++) {
      if(pre[next][next + i]) {
        part.add(s.substring(next, next + i + 1));
        partitions(s, part, next + i + 1, pre);
        part.remove(part.size() - 1);
      } 
    }
  }

  private boolean[][] isPalindrome(String s) {
    boolean[][] res = new boolean[s.length()][s.length()];
    // res[i][j] indicates whether the substring from i to j (inclusive) is a palindrome
    // res[i][j] = res[i+1][j-1] if s.charAt(i) == s.charAt(j) i+1 <= j-1
    for(int j = 0; j < s.length(); j++) {
      for(int i = 0; i < s.length(); i++) {
        if(i == j || (i + 1 == j && s.charAt(i) == s.charAt(j))) {
          res[i][j] = true;
        }
        if(i + 1 <= j - 1 && s.charAt(i) == s.charAt(j)) {
          res[i][j] = res[i+1][j-1];
        }
      }
    }
    return res;
  }
}
