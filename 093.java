public class Solution {
  public List<String> restoreIpAddresses(String s) {
    List<String> res = new ArrayList<>();
    if(s.length() == 0) {
      return res;
    }
    getIP(res, 0, -1, s, "");
    return res;
  }
    
  public void getIP(List<String> res, int level, int last, String s, String t) {
    if(level == 4) {
      if(last == s.length()-1) {
        res.add(t.substring(0, t.length()-1));
      }
      return;
    }
    for(int i = 1; i <= 3; i++) {
      if(last+1+i <= s.length()) {
        String sub = s.substring(last+1, last+1+i);
        int temp = Integer.parseInt(sub);
        if(i == 1 || (i > 1 && temp <= 255 && s.charAt(last+1) != '0')) {
          getIP(res, level+1, last+i, s, t+sub+".");
        }
      }
    }
  }
}
