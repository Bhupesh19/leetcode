public class Solution {
  public int calculateMinimumHP(int[][] dungeon) {
    int[][] needed = new int[dungeon.length][dungeon[0].length];
    // needed[i][j] indicates HP needed
    // dungeon[i][j] stores how much HP would be left
    if(dungeon[0][0] <= 0) {
      needed[0][0] = 1 - dungeon[0][0];
      dungeon[0][0] = 1;
    } else {
      needed[0][0] = 1;
      dungeon[0][0] += 1;
    }

    // first col
    for(int i = 1; i < dungeon.length; i++) {
      if(dungeon[i][0] + dungeon[i - 1][0] <= 0) {
        needed[i][0] = 1 - (dungeon[i][0] + dungeon[i - 1][0]);
        dungeon[i][0] = 1;
      } else {
        needed[i][0] = needed[i - 1][0];
        dungeon[i][0] += dungeon[i - 1][0];
      }
    }
    
    for(int j = 1; j < dungeon[0].length; j++) {
      if(dungeon[0][j] + dungeon[0][j - 1] <= 0) {
        needed[0][j] = 1 - (dungeon[0][j] + dungeon[0][j - 1]);
        dungeon[0][j] = 1;
      } else {
        needed[0][j] = needed[0][j - 1];
        dungeon[0][j] += dungeon[0][j - 1];
      }
    }
  
    for(int i = 1; i < dungeon.length; i++) {
      for(int j = 1; j < dungeon[0].length; j++) {
        int m = 0, n = 0;
        if(needed[i - 1][j] < needed[i][j - 1]) {
          m = i - 1;
          n = j;
        } else {
          m = i;
          n = j - 1;
        }
        if(dungeon[i][j] + dungeon[m][n] <= 0) {
          needed[i][j] = 1 - (dungeon[i][j] + dungeon[m][n]);
          dungeon[i][j] = 1;
        } else {
          needed[i][j] = needed[m][n];
          dungeon[i][j] += dungeon[m][n]; 
        }
      }
    }
    return needed[needed.length - 1][needed[0].length - 1];
  }
}
