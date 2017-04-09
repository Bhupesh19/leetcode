public class Solution {
  public boolean checkSubarraySum(int[] nums, int k) {
    int sum = 0;
    if(k == 0) {
      for(int i = 0; i < nums.length - 1; i++) {
        if(nums[i] == nums[i+1] && nums[i] == 0) {
          return true;
        } 
      }
      return false;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
      sum += nums[i];
      int modulo = sum % k;
      if((i >= 1 && sum % k == 0) || (map.containsKey(modulo) && i - map.get(modulo) > 1)) {
        return true;
      }
      if(!map.containsKey(modulo)) {
        map.put(modulo, i);
      }
    }
    return false;   
  }
}
