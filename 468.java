class Solution {
  public String validIPAddress(String IP) {
    if (IP.indexOf(".") != -1 && isIPv4(IP)) {
      return "IPv4";
    }
    if (IP.indexOf(":") != -1 && isIPv6(IP)) {
      return "IPv6";
    }
    return "Neither";
  }
    
  private boolean isIPv4(String ip) {
    int i = 0;
    int count = 0;
    while (i < ip.length()) {
      int j = i;
      while (j < ip.length() && ip.charAt(j) != '.') {
        char c = Character.toLowerCase(ip.charAt(j));
        if (c > '9' || c < '0') {
          return false;
        }
        j++;
      }
      if (j == ip.length() - 1 && ip.charAt(j) == '.') {
        return false;
      }
      String part = ip.substring(i, j);
      if (part.equals("") || hasLeadingZeroes(part) || part.length() > 3 || Integer.parseInt(part) > 255) {
        return false;
      }
      count++;
      i = j + 1;
    }
    return count == 4;
  }
    
  private boolean hasLeadingZeroes(String s) {
    return s.startsWith("0") && s.length() != 1;
  }
    
  private boolean isIPv6(String ip) {
    int i = 0;
    int count = 0;
    while (i < ip.length()) {
      int j = i;
      while (j < ip.length() && ip.charAt(j) != ':') {
        char c = Character.toLowerCase(ip.charAt(j));
        if ((c > '9' || c < '0') && (c < 'a' || c > 'f'))  {
          return false;
        }
        j++;
      }
      if (j == ip.length() - 1 && ip.charAt(j) == ':') {
        return false;
      }
      String part = ip.substring(i, j);
      if (part.equals("") || hasExtraZeroes(part) || part.length() > 4) {
        return false;
      }
      count++;
      i = j + 1;
    }
    return count == 8;
  }
    
  private boolean hasExtraZeroes(String s) {
    return s.startsWith("0") && s.length() > 4;
  }
}
