class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
    char pos = target;
    char neg = target;
    for (char letter : letters) {
      int diff = letter - target;
      if (diff > 0 && (diff < pos - target || pos == target)) {
        pos = letter;
      }
      if (diff < 0 && (diff < neg - target || neg == target)) {
        neg = letter;
      }
    }
    if (pos != target) return pos;
    return neg;
  }
}
