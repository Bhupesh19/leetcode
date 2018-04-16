class Solution {
  public List<String> ambiguousCoordinates(String S) {
    // the basic idea to solve this problem is to first find where to put the comma first
    // then use two arraylists, collect all possible left parts and right parts
    List<String> results = new ArrayList<>();
    for (int i = 1; i < S.length() - 2; i++) {
      List<String> leftNums = new ArrayList<>();
      List<String> rightNums = new ArrayList<>();
      findValidNums(leftNums, S, 1, i);
      findValidNums(rightNums, S, i + 1, S.length() - 2);
      for (String a: leftNums) {
        for (String b: rightNums) {
          results.add("(" + a + ", " + b + ")");
        }
      }
    }
    return results;
  }
    
  private void findValidNums(List<String> validNums, String S, int l, int r) {
    if (l == r) {
      validNums.add(S.substring(l, l + 1));
      return;
    }
    String t = S.substring(l, r + 1);
    if (hasNoLeadingZeroes(t)) {
      validNums.add(t);
    }
    for (int i = l; i < r; i++) {
      String integ = S.substring(l, i + 1);
      String decimal = S.substring(i + 1, r + 1);
      if (hasNoLeadingZeroes(integ) && hasNoTrailingZeroes(decimal)) {
        validNums.add(integ + "." + decimal);
      }
    }
  }
    
  private boolean hasNoLeadingZeroes(String t) {
    return !t.startsWith("0") || t.length() == 1;
  }
    
  private boolean hasNoTrailingZeroes(String t) {
    return !t.endsWith("0");
  }
}
