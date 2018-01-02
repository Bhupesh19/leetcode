class Solution {
  public int numberOfArithmeticSlices(int[] A) {
    int[] nums = new int[A.length];
    if (A.length <= 2) {
      return 0;
    }
    int step = A[1] - A[0];
    int start = 0;
    for (int i = 2; i < A.length; i++) {
      if (A[i] - A[i - 1] == step) {
        nums[i] = nums[i - 1] + i - 1 - start;
      } else {
        nums[i] = nums[i - 1];
        step = A[i] - A[i - 1];
        start = i - 1;
      }
    }
    return nums[A.length - 1];
  }
}
