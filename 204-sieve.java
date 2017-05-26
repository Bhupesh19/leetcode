public class Solution {
  public int countPrimes(int n) {
    boolean[] nums = new boolean[n];
    for(int i = 2; i * i < n; i++) {
      if(!nums[i]) {
        for(int j = i; i * j < n; j++) {
          nums[i * j] = true; 
        }
      }
    }
    int count = 0;
    for(int i = 0; i < n; i++) {
      if(!nums[i]) {
        count++;
      }
    }
    return (n < 2) ? 0 : count - 2;
  }
}
