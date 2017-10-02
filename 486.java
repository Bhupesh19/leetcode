class Solution {
  public boolean PredictTheWinner(int[] nums) {
    return predict(nums, 0, nums.length - 1, 0, 0, true); 
  }

  private boolean predict(int[] nums, int start, int end, int sum1, int sum2, boolean turn) {
    if(start > end) {
      return sum1 >= sum2;
    }
    if(turn) {
      return predict(nums, start + 1, end, sum1 + nums[start], sum2, !turn) || predict(nums, start, end - 1, sum1 + nums[end], sum2, !turn);
    } else {
      return predict(nums, start + 1, end, sum1, sum2 + nums[start], !turn) && predict(nums, start, end - 1, sum1, sum2 + nums[end], !turn);
    }
  }
}
