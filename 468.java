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
    String[] parts = ip.split("\\.");
    if (parts.length != 4 || ip.charAt(ip.length() - 1) == '.') {
      return false;
    }
    for (String part : parts) {
      for (int i = 0; i < part.length(); i++) {
        char c = Character.toLowerCase(part.charAt(i));
        if (c > '9' || c < '0') {
          return false;
        }
      }
      if (part.length() == 0 || part.length() > 3 || hasLeadingZeroes(part) || Integer.valueOf(part) > 255) {
        return false;
      }
    }
    return true;
  }
    
  private boolean hasLeadingZeroes(String s) {
    return s.startsWith("0") && s.length() != 1;
  }
    
  private boolean isIPv6(String ip) {
    String[] parts = ip.split(":");
    if (parts.length != 8 || ip.charAt(ip.length() - 1) == ':') {
      return false;
    }
    for (String part : parts) {
      for (int i = 0; i < part.length(); i++) {
        char c = Character.toLowerCase(part.charAt(i));
        if ((c > '9' || c < '0') && (c < 'a' || c > 'f')) {
          return false;
        }
      }
      if (part.length() == 0 || part.length() > 4 || hasExtraZeroes(part)) {
        return false;
      }
    }
    return true;
  }
    
  private boolean hasExtraZeroes(String s) {
    return s.startsWith("0") && s.length() > 4;
  }
}
