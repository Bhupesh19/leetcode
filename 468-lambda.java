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
      boolean b1 = false;
      b1 = part.chars()
              .map(c -> Character.toLowerCase(c))
              .anyMatch(c -> (c > '9' || c < '0') && (c < 'a' || c > 'f'));
      if (b1) {
        return false;
      }
    }
    boolean b2 = Arrays.stream(parts)
            .anyMatch(s -> s.length() == 0 || s.length() > 4);
    if (b2) {
      return false;
    }
    return true;
  }
}
