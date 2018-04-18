class Solution {
  public boolean validUtf8(int[] data) {
    int i = 0;
    while (i < data.length) {
      if (data[i] < 0 || data[i] > 255) {
        return false;
      }
      String first = getString(data[i]);
      int n = 0;
      if (first.startsWith("0")) {
        n = i;
      } else if (first.startsWith("110")) {
        n = i + 1;
      } else if (first.startsWith("1110")) {
        n = i + 2;
      } else if (first.startsWith("11110")) {
        n = i + 3;
      } else {
        return false;   
      }
      i++;
      if (n >= data.length) {
        return false;
      }
      for (; i <= n; i++) {
        if (data[i] < 0 || data[i] > 255 || !getString(data[i]).startsWith("10")) {
          return false;
        }
      }
    }
    return true;
  }

  private String getString(int a) {
    String bs = Integer.toBinaryString(a);
    for (int i = bs.length(); i < 8; i++) {
      bs = "0" + bs;
    } 
    return bs;
  }
}
