public class Solution {
  public boolean isHappy(int n) {
    Set<Integer> nums = new HashSet<>();
    int sum = 0;
    while(n != 1) {
      while(n > 0) {
        sum += (n % 10) * (n % 10);
        n /= 10;
      }
      if(nums.contains(sum)) {
        return false;
      }
      n = sum;
      nums.add(n);
      sum = 0;
    }
    return true;
  }
}
