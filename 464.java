class Solution {
    
  private Map<Integer, Map<Integer, Boolean>> memo;
    
  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if ( ( 1 + maxChoosableInteger ) * (maxChoosableInteger) / 2 < desiredTotal ) {
      return false;
    }
    memo = new HashMap<Integer, Map<Integer, Boolean>>();
    return enumerate(maxChoosableInteger, 0, desiredTotal, 0);
  }

  private boolean enumerate(int maxChoosableInteger, int total, int desiredTotal, int used) {
    if (memo.containsKey(used) && memo.get(used).containsKey(total)) {
      return memo.get(used).get(total);
    }
    if (!memo.containsKey(used)) {
      memo.put(used, new HashMap<Integer, Boolean>());
    }
    for (int i = 1; i <= maxChoosableInteger; i++) {
      if ((used & (1 << i)) == 0) {
        used |= (1 << i);
        if (total + i >= desiredTotal) {
          used &= ~ (1 << i);
          memo.get(used).put(total, true);
          return true;
        }
        if (!enumerate(maxChoosableInteger, total + i, desiredTotal, used)) {
          used &= ~ (1 << i);
          memo.get(used).put(total, true);
          return true;
        }
        used &= ~ (1 << i);
      }
    }
    memo.get(used).put(total, false);
    return false;
  }
}
