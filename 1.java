public class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> num_index = new HashMap<>();
    int[] res = new int[2];
    for(int i = 0; i < nums.length; i++) {
      if(num_index.containsKey(target - nums[i])) {
        res[0] = num_index.get(target - nums[i]);
        res[1] = i;
        return res;
      }
      num_index.put(nums[i], i);
    }
    return res;
  }
}
