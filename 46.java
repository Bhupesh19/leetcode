public class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();
    if(nums.length == 0) {
      return results;
    }
    permutations(results, nums, 0);
    return results;
  }

  private void permutations(List<List<Integer>> results, int[] nums, int level) {
    if(level == nums.length) {
      List<Integer> per = new ArrayList<>();
      for(int num : nums) {
        per.add(num);
      }
      results.add(per);
      return;
    }
    for(int i = level; i < nums.length; i++) {
      int temp = nums[level];
      nums[level] = nums[i];
      nums[i] = temp;
      permutations(results, nums, level+1);
      temp = nums[level];
      nums[level] = nums[i];
      nums[i] = temp;
    }
  }
}
