public class Solution {
  public void sortColors(int[] nums) {
    int start = 0, end = nums.length - 1;
    int i = start, j = end;
    while(start <= end) {
      while(start < nums.length && nums[start] == 0) {
        start++;
      }
      while(end >= 0 && nums[end] == 2) {
        end--;
      }
      i = start + 1;
      j = end - 1;
      while(i <= end && nums[i] != 0) {
        i++;
      }
      if(i < end) {
        nums[i] = nums[start];
        nums[start] = 0;
        start++;
      }
      if(j > start) {
        nums[j] = nums[end];
        nums[end] = 2;
        end--;
      }
      if(i >= end && j <= start) {
        break;
      }  
    }
  }
}
