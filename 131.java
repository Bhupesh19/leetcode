public class Solution {

  private List<List<String>> res = new ArrayList<>();

  public List<List<String>> partition(String s) {
    if(s.length() == 0) {
      return res;
    }
    List<String> part = new ArrayList<>();
    partitions(s, part, 0);
    return res;
  }

  private void partitions(String s, List<String> part, int next) {
    if(next == s.length()) {
      res.add(new ArrayList<String>(part));
      return;
    }
    for(int i = 0; i < s.length() - next; i++) {
      String temp = s.substring(next, next + i + 1);
      if(isPalindrome(temp)) {
        part.add(temp);
        partitions(s, part, next + i + 1);
        part.remove(part.size() - 1);
      } 
    }
  }

  private boolean isPalindrome(String s) {
    for(int i = 0; i < s.length() - i - 1; i++) {
      if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
