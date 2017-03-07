public class Solution {
  
  List<List<Integer>> res = new ArrayList<>();
  
  public List<List<Integer>> subsets(int[] nums) {
    Arrays.sort(nums);
    for(int i = 0; i <= nums.length; i++) {
      getSubsets(nums, i, new ArrayList<Integer>(), 0); 
    }
    return res;  
  }

  private void getSubsets(int[] nums, int num, List<Integer> subset, int level) {
    if(level == num) {
      res.add(new ArrayList<Integer>(subset));
      return;
    }
    int last = Integer.MIN_VALUE;
    if(level > 0) {
      last = subset.get(subset.size()-1);
    }
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] > last) {
        subset.add(nums[i]);
        getSubsets(nums, num, subset, level+1);
        subset.remove(subset.size()-1);
      }
    }
  } 
}
