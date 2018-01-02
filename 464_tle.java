class Solution {
    
  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    return enumerate(maxChoosableInteger, 0, desiredTotal, 0);
  }

  private boolean enumerate(int maxChoosableInteger, int total, int desiredTotal, int used) {
    for (int i = 1; i <= maxChoosableInteger; i++) {
      if ((used & (1 << i)) == 0) {
        used |= (1 << i);
        if (total + i >= desiredTotal) {
          used &= ~ (1 << i);
          return true;
        }
        if (!enumerate(maxChoosableInteger, total + i, desiredTotal, used)) {
          used &= ~ (1 << i);
          return true;
        }
        used &= ~ (1 << i);
      }
    }
    return false;
  }
}
