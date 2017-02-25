public class Solution {
  private char[] roman = new char[] {'I', 'V', 'X', 'L', 'C', 'D', 'M'}; 
  
  public String intToRoman(int num) {
    StringBuilder str = new StringBuilder("");
    for(int i = 3; i >= 0; i--) {
      int digit = num / (int)Math.pow(10, i);
      if(digit <= 3) {
        for(int j = 0; j < digit; j++) {
          str.append(roman[i*2]);
        }
      } 
      if(digit == 4) {
        str.append(roman[i*2]);
      }
      if(digit >= 4 && digit <= 8) {
        str.append(roman[i*2+1]);
      }
      if(digit >= 5 && digit <= 8) {
        for(int j = 0; j < digit-5; j++) {
          str.append(roman[i*2]);
        }
      } 
      if(digit == 9) {
        str.append(roman[i*2]);
        str.append(roman[i*2+2]);
      }
      num = num % (int)Math.pow(10, i); 
    }
    return str.toString(); 
  }
}
