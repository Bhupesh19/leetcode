class Solution {
  public int maximumSwap(int num) {
    String s = Integer.toString(num);
    char prevMax = s.charAt(s.length() - 1);
    int index = s.length() - 1;
    for(int i = s.length() - 2; i >= 0; i--) {
      if(s.charAt(i) < prevMax) {
        index = i;
      }
      if(s.charAt(i) > prevMax) {
        prevMax = s.charAt(i);
      }
    }
    if(index == s.length() - 1) return num;
    int maxIndex = index;
    char max = s.charAt(index);
    for(int i = index + 1; i < s.length(); i++) {
      if(s.charAt(i) >= max) {
        max = s.charAt(i);
        maxIndex = i;
      }
    }
    String res = s.substring(0, index) + s.charAt(maxIndex) + s.substring(index + 1, maxIndex) + s.charAt(index) + s.substring(maxIndex + 1, s.length());
    return Integer.parseInt(res);
  }
}
