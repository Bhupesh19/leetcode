public class Solution {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int res = nums[0] + nums[1] + nums[2];
    for(int i = 0; i < nums.length - 2; i++) {
      int low = i + 1, high = nums.length - 1;
      while(low < high) {
        int curr = nums[low] + nums[high] + nums[i];
        if(curr == target) {
          res = target;
          return res;
        }
        res = (Math.abs(target - curr) < Math.abs(target - res)) ? curr : res; 
        if(curr < target) {
          low++;
        } else {
          high--;
        }
      }
    }
    return res;
  }
}
