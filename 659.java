public class Solution {
  public boolean isPossible(int[] nums) {
    if(nums.length < 3) return false;
    List<List<Integer>> res = new ArrayList<>();
    for(int i = 0; i < nums.length; i++) {
      int index = -1;
      for(int j = 0; j < res.size(); j++) {
        List<Integer> li = res.get(j);
        if(li.get(li.size() - 1) == nums[i]) {
          continue;
        }
        if(li.size() == 0 || li.size() < 3 && nums[i] - li.get(li.size() - 1) == 1) {
          index = j;
          break; 
        }
        if(nums[i] - li.get(li.size() - 1) == 1) {
          index = j;
        }
      }
      if(index == -1) {
        res.add(new ArrayList<Integer>());
        res.get(res.size() - 1).add(nums[i]);
      } else {
        res.get(index).add(nums[i]);
      }
    }
    for(List<Integer> li : res) {
      if(li.size() < 3) {
        return false;
      }
    }
    return true;
  }
}
