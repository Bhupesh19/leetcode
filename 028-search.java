public class Solution {
  public int strStr(String haystack, String needle) {
    int index = -1;
    for(int i = 0; i < haystack.length(); i++) {
      if(i+needle.length()-1 < haystack.length() && haystack.substring(i, i+needle.length()).equals(needle)) {
        index = i;
        break;
      }
    }
    return (needle.length() == 0) ? 0 : index;
  }
} 
