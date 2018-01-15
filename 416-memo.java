class Solution {
    
  private int sum = 0;
  private Map<Integer, Boolean> map = new HashMap<>();
    
  public boolean canPartition(int[] nums) {
    for (int num : nums) {
      sum += num;
    }
    return canPar(nums, 0, 0);   
  }
    
  private boolean canPar(int[] nums, int total, int level) {
    if (total * 2 == sum) {
      return true;
    }
    if (level == nums.length) {
      return false;
    }
    if (map.containsKey(total)) {
      return map.get(total);
    } 
    boolean can = canPar(nums, total + nums[level], level + 1) || canPar(nums, total, level + 1);
    map.put(total, can);
    return can;
  }
}
