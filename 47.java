public class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();
    if(nums.length == 0) {
      return results;
    }
    permute(results, nums, 0);
    return results; 
  }
  
  private void permute(List<List<Integer>> results, int[] nums, int level) {
    if(level == nums.length) {
      List<Integer> per = new ArrayList<>();
      for(int num : nums) {
        per.add(num);
      }
      results.add(per);
    }
    Set<Integer> repetition = new HashSet<>();
    for(int i = level; i < nums.length; i++) {
      if(repetition.add(nums[i])) {
        int temp = nums[level];
        nums[level] = nums[i];
        nums[i] = temp;
        permute(results, nums, level+1);
        temp = nums[level];
        nums[level] = nums[i];
        nums[i] = temp;
      }
    }
  }
}
