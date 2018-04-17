class Solution {
  public String validIPAddress(String IP) {
    if (isIPv4(IP)) {
      return "IPv4";
    }
    if (isIPv6(IP)) {
      return "IPv6";
    }
    return "Neither";
  }
    
  private boolean isIPv4(String ip) {
    String[] parts = ip.split("\\.", -1);
    if (parts.length != 4) {
      return false;
    }
    for (String part : parts) {
      int number = 0;
      for (int i = 0; i < part.length(); i++) {
        char c = part.charAt(i);
        if (c > '9' || c < '0') {
          return false;
        }
        number = number * 10 + c - '0';
      }
      if (part.length() == 0 || part.length() > 3 || hasLeadingZeroes(part) || number > 255) {
        return false;
      }
    }
    return true;
  }
    
  private boolean hasLeadingZeroes(String s) {
    return s.startsWith("0") && s.length() != 1;
  }
    
  private boolean isIPv6(String ip) {
    String[] parts = ip.split(":", -1);
    if (parts.length != 8) {
      return false;
    }
    for (String part : parts) {
      for (int i = 0; i < part.length(); i++) {
        char c = Character.toLowerCase(part.charAt(i));
        if ((c > '9' || c < '0') && (c < 'a' || c > 'f')) {
          return false;
        }
      }
      if (part.length() == 0 || part.length() > 4) {
        return false;
      }
    }
    return true;
  }
}

