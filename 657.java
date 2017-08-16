public class Solution {
  public boolean judgeCircle(String moves) {
    int i = 0, j = 0;
    for(int i = 0; i < moves.length(); i++) {
      switch(moves.charAt(i)) {
        case 'U':
          --i;
          break;
        case 'D':
          ++i;
          break;
        case 'L':
          --j;
          break;
        case 'R':
          ++j;
          break;
        default:
          throw new Exception("Invalid input!");
        }
    }
    return i == 0 && j == 0;
  }
}
