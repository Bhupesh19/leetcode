public class Solution {
  
  private int counter = 0;  

  public int findTargetSumWays(int[] nums, int S) {
    findWays(nums, 0, S);
    return counter;
  }

  private void findWays(int[] nums, int index, int S) {
    if(index == nums.length) {
      if(S == 0) counter++;
      return;
    }
    findWays(nums, index + 1, S - nums[index]); 
    findWays(nums, index + 1, S + nums[index]); 
  }
}
