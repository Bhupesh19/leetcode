public class Solution {
  
  Set<List<Integer>> res = new HashSet<>();

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    for(int i = 0; i <= nums.length; i++) {
      subsets(nums, i, new ArrayList<Integer>(), 0);   
    }
    List<List<Integer>> results = new ArrayList<>();
    for(List<Integer> list : res) {
      results.add(list);
    }
    return results;  
  }

  private void subsets(int[] nums, int num, List<Integer> subsetIndex, int level) {
    if(level == num) {
      List<Integer> subset = new ArrayList<>();
      for(Integer i : subsetIndex) {
        subset.add(nums[i]);
      }
      res.add(subset);
      return;
    }
    int last = -1; 
    if(level > 0) {
      last = subsetIndex.get(subsetIndex.size()-1);
    }
    for(int i = last+1; i < nums.length; i++) {
      subsetIndex.add(i);
      subsets(nums, num, subsetIndex, level+1);
      subsetIndex.remove(subsetIndex.size()-1);
    }
  }
}
