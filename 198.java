public class Solution {
  public int rob(int[] nums) {
    int a = 0, b = 0;
    for(int i = 0; i < nums.length; i++) {
      if(a + nums[i] > b) {
        int temp = b;
        b = a + nums[i];
        a = temp;
      } else {
        a = b;
      } 
    }
    return b;
  }
}
