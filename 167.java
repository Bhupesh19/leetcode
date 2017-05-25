public class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int low = 0, high = numbers.length - 1;
    int[] res = new int[] {-1, -1};
    while(low < high) {
      if(numbers[low] + numbers[high] == target) {
        res[0] = low + 1;
        res[1] = high + 1;
        break;
      }
      if(numbers[low] + numbers[high] < target) {
        low++;
      } else {
        high--;
      }
    }
    return res;
  }
}
