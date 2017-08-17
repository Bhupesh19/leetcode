public class Solution {
  private int counter = 0;

  public int countArrangement(int N) {
    int[] nums = new int[N];
    for(int i = 0; i < N; i++) {
      nums[i] = i + 1; 
    }
    calculate(nums, 0);
    return counter;
  }

  private void calculate(int[] nums, int level) {
    if(level == nums.length) {
      counter++;
      return;
    }
    for(int i = level; i < nums.length; i++) {
      int temp = nums[level];
      nums[level] = nums[i];
      nums[i] = temp;
      if(nums[level] % (level + 1) == 0 || (level + 1) % nums[level] == 0) {
        calculate(nums, level + 1);
      }
      nums[i] = nums[level];
      nums[level] = temp;
    }
  }
}
