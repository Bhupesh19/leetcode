public class Solution {
  public String predictPartyVictory(String senate) {
    int numR = 0;
    int numD = 0;
    while(senate.indexOf('D') != -1 && senate.indexOf('R') != -1) {
      StringBuilder ss = new StringBuilder("");
      for(int i = 0; i < senate.length(); i++) {
        if(senate.charAt(i) == 'R') {
          if(numR > 0) {
            numR--;
          } else {
            ss.append('R');
            numD++;
          }
        }
        if(senate.charAt(i) == 'D') {
          if(numD > 0) {
            numD--;
          } else {
            ss.append('D');
            numR++;
          }
        }
      }
      senate = ss.toString();
    }
    return (senate.indexOf('D') != -1) ? "Dire" : "Radiant";
  }
}
