public class Solution {
  public int maximumProduct(int[] nums) {
    Arrays.sort(nums);
    int max = Integer.MIN_VALUE;
    int cur = 1; 
    for(int i = 0; i < 3; i++) {
      cur *= nums[nums.length - 1 - i];
    }
    return Math.max(nums[0] * nums[1] * nums[nums.length - 1], Math.max(cur, max));
  }
}
