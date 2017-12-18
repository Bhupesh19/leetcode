class Solution {
  public int[] countBits(int num) {
    int[] counts = new int[num + 1];
    for (int i = 0 ; i <= num; i++) {
      counts[i] = counts[i / 2] + i % 2;
    }
    return counts;
  }
}
