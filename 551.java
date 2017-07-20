public class Solution {
  public boolean checkRecord(String s) {
    boolean isRewarded = true;
    boolean a = false;
    int l = 0;
    for(int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == 'A') {
        if(a) {
          return false;
        }
        a = !a;
        l = 0;
      }
      if(s.charAt(i) == 'L') {
        ++l;
        if(l > 2) {
          return false;
        }
      }
      if(s.charAt(i) == 'P') {
        l = 0;
      }
    }
    return true;
  }
}
