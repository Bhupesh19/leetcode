public class Solution {
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    if (isPerpendicular(p1, p2, p3, p4)) {
      return isPerpendicular(p1, p3, p1, p4) && isPerpendicular(p4, p1, p4, p2);
    }
    if (isPerpendicular(p1, p3, p2, p4)) {
      return isPerpendicular(p1, p2, p1, p4) && isPerpendicular(p4, p1, p4, p3);
    }
    if (isPerpendicular(p1, p4, p2, p3)) {
      return isPerpendicular(p1, p2, p1, p3) && isPerpendicular(p3, p1, p3, p4);
    }
    return false;
  }
    
  private boolean isPerpendicular(int[] p1, int[] p2, int[] p3, int[] p4) {
    if (p1[0] == p2[0]) {
      return p1[1] != p2[1] && p3[1] == p4[1];
    }
    if (p3[0] == p4[0]) {
      return p3[1] != p4[1] && p1[1] == p2[1];
    }
    if ((p2[1] - p1[1]) * (p4[1] - p3[1]) / (p2[0] - p1[0]) / (p4[0] - p3[0]) == -1) {
      return true;
    }
    return false;
  }
}
