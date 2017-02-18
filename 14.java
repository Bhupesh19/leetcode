public class Solution {
  public String longestCommonPrefix(String[] strs) {
    if(strs.length == 0) {
      return "";
    }
    String prefix = strs[0];
    for(int i = 1; i < strs.length; i++) {
      if(prefix.length() == 0) {
        break;
      }
      prefix = commonPrefix(prefix, strs[i]);
    }
    return prefix;
  }
  
  private String commonPrefix(String str1, String str2) {
    StringBuilder prefix = new StringBuilder("");
    int len = (str1.length() > str2.length()) ? str2.length() : str1.length();
    for(int i = 0; i < len; i++) {
      if(str1.charAt(i) != str2.charAt(i)) {
        break;
      }
      prefix.append(str1.charAt(i));
    }
    return prefix.toString();  
  }
}
