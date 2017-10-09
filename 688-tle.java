class Solution {
  public double knightProbability(int N, int K, int r, int c) {
    if(r < 0 || r >= N || c < 0 || c >= N) return 0;
    if(K == 0) return 1;
    double p = 1.0 / 8 * knightProbability(N, K - 1, r - 2, c - 1)
             + 1.0 / 8 * knightProbability(N, K - 1, r - 2, c + 1)
             + 1.0 / 8 * knightProbability(N, K - 1, r + 2, c - 1)
             + 1.0 / 8 * knightProbability(N, K - 1, r + 2, c + 1)
             + 1.0 / 8 * knightProbability(N, K - 1, r - 1, c - 2)
             + 1.0 / 8 * knightProbability(N, K - 1, r - 1, c + 2)
             + 1.0 / 8 * knightProbability(N, K - 1, r + 1, c - 2)
             + 1.0 / 8 * knightProbability(N, K - 1, r + 1, c + 2);
    return p;
  }
}
