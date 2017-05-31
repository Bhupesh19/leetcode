public class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> res = new HashSet<>();
    for(int num : nums) {
      if(!res.add(num)) {
        return true;
      }
    }
    return false;
  }
}
