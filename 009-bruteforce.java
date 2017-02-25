public class Solution {
  public boolean isPalindrome(int x) {
    String str = Integer.toString(x);
    for(int i = 0; 2 * i + 1 <= str.length(); i++) {
      if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
        return false;
      }
    }
    return true; 
  }
}
