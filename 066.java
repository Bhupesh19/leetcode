public class Solution {
  public int[] plusOne(int[] digits) {
    int c = 1;
    for(int i = digits.length - 1; i >= 0; i--) {
      int digit = digits[i];
      digits[i] = (c + digits[i]) % 10;
      c = (c + digit) / 10;
    }
    if(c == 0) {
      return digits;
    }
    int[] results = new int[digits.length+1];
    results[0] = 1;
    return results; 
  }
}
