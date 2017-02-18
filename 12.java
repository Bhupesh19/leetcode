public class Solution {
  
  private String[] roman = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}; 
  
  private int[] nums = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
 
  public String intToRoman(int num) {
    StringBuilder str = new StringBuilder("");
    for(int i = 0; i < roman.length; i++) {
      while(num >= nums[i]) {
        str.append(roman[i]);
        num -= nums[i];
      }
    }
    return str.toString(); 
  }
}
