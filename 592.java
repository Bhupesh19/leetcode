class Solution {
  private long numerator = 0;
  private long denominator = 1;
    
  public String fractionAddition(String expression) {
    int i = 0;
    while (i < expression.length()) {
      int start = i;
      while (expression.charAt(i) != '/') {
        i++;
      }
      String nume = expression.substring(start, i);
      start = i;
      while (i < expression.length() && expression.charAt(i) != '+' && expression.charAt(i) != '-') {
        i++;
      }
      String deno = expression.substring(start + 1, i);
      update(nume, deno);
    }
    return numerator + "/" + denominator;
  }
    
  private void update(String nume, String deno) {
    long num = Long.parseLong(nume);
    long den = Long.parseLong(deno);
    long d = denominator * den;
    long n = numerator * den + num * denominator;
    long common = 1;
    for (long i = Math.max(n, d); i > 0; i--) {
      if (n % i == 0 && d % i == 0) {
        common = i;
        break;
      }
    }
    numerator = n / common;
    denominator = d / common;
  }
}
