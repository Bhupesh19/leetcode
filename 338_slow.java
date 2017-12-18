class Solution {
  public int[] countBits(int num) {
    int[] counts = new int[num + 1];
    for (int i = 0 ; i <= num; i++) {
      int j = i;
      while (j > 0) {
        if (j % 2 == 1) {
          counts[i]++;
        }
        j /= 2;
      }
    }
    return counts;
  }
}
