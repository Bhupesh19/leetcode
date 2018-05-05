class Solution {
  double max = Double.MIN_VALUE;
    
  public double largestSumOfAverages(int[] A, int K) {
    double[] sums = new double[A.length];
    sums[0] = A[0];
    for (int i = 1; i < A.length; i++) {
      sums[i] = A[i] + sums[i - 1];
    }
    computeAverages(A, K, -1, 1, 0, sums);
    return max;
  }
    
  private void computeAverages(int[] A, int K, int lastIndex, int nth, double sum, double[] sums) {
    if (nth == K + 1 && lastIndex == A.length - 1) {
      max = Math.max(max, sum);
      return;
    }
    if (lastIndex == A.length - 1) {
      return;
    }
    if (nth == K + 1) {
      return;
    }
    for (int i = lastIndex + 1; i < A.length; i++) {
      double cur = 0;
      if (lastIndex + 1 == 0) {
        cur = sums[i] / (i + 1);
      } else {
        cur = (sums[i] - sums[lastIndex]) / (i - lastIndex); 
      }
      computeAverages(A, K, i, nth + 1, sum + cur, sums);
    }
  }
}
