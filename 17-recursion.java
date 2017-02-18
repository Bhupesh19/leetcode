public class Solution {
  private String[] numStrs = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {
    List<String> results = new ArrayList<>();
    if(digits.length() == 0) {
      return results;
    }
    findLetterCombs(digits, "", 0, results); 
    return results;
  }

  private void findLetterCombs(String digits, String letters, int level, List<String> results) {
    if(level == digits.length()) {
      results.add(letters);
      return;
    }
    int index = digits.charAt(level) - '0';
    for(int i = 0; i < numStrs[index].length(); i++) {
      findLetterCombs(digits, letters+numStrs[index].charAt(i), level+1, results); 
    }   
  }
}
