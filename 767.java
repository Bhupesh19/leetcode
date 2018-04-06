class Solution {
  public String reorganizeString(String S) {
    // the solution to this problem might be divided into two parts: 1) how to detect if a string can be rearranged in the certain way 2) build the string according to the requirements
    // 1) analysis: consider a string with only first two chars are the same, for example aab, aababa, aabaca after some reorganization. assume the length of this string is n, if we try to move the first 'a' of the string to make it work, then since we have now n-1 chars left (n empty spaces to insert), the list must have at least n/2 'a' in the remaining chars. So we can calculate, as long as the most frequent number does not appear more than n/2 times, we are fine
    // 2) analysis: when we are trying to rearrange the string, the possible result must satify the following rules: for every substring, the most frequent number (with this substring) should not appear more than n/2 times where n is even. When n is odd, should not be more than (n + 1) / 2
    // char with high freq should be arranged as soon as possible to avoid "adjacent same"
    // use a map to store all pairs (char, freq)
    // put all map entries into a max heap where the priority is decided by freq
    // every time poll the priority queue, append the char with the hightest freq, reduce the freq and add it back. if there are multiple highest freq numbers, append them by turns. If the hightest freq numbers is still the same one as previous, insert the second higheset freq number first
        // notice: aaabb, <a, 3> <b, 2>, the process will go as (1) string: "a" heap: <a, 2>, <b, 2>. We can not insert a again so every time we need to check the previous char; aaaabbcc, (1) string: "a" heap: <a, 3> <b, 2> <c, 2>. in this case we have to insert the second hightest freq number; (2) string: "ab", heap <a, 3> <b, 1> <c, 2>; (3) string: "aba" <a, 2> <b, 1> <c, 2>...
    // n*log m, m < n
    Map<Character, Integer> occurs = new HashMap();
    for (char c : S.toCharArray()) {
      occurs.put(c, occurs.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Map.Entry<Character, Integer>> freqs = new PriorityQueue<>(occurs.size(), (a, b) -> b.getValue() - a.getValue());
    for (Map.Entry entry : occurs.entrySet()) {
      freqs.offer(entry);
    }
    int counts = freqs.peek().getValue();
    int len = S.length();
    if (len % 2 == 0 && counts > len / 2 || len % 2 == 1 && counts > (len + 1) / 2) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    while (freqs.peek().getValue() != 0) {
      Map.Entry<Character, Integer> cur = freqs.poll();
      if (sb.length() - 1 >= 0 && cur.getKey() == sb.charAt(sb.length() - 1)) {
        Map.Entry<Character, Integer> sec = freqs.poll();
        sb.append(sec.getKey());
        freqs.offer(cur);
        sec.setValue(sec.getValue() - 1);
        freqs.offer(sec);
        continue;   
      }
      int counter = cur.getValue();
      sb.append(cur.getKey());
      cur.setValue(counter - 1);
      freqs.offer(cur);
      while (!freqs.isEmpty() && freqs.peek().getValue() == counter) {
        Map.Entry<Character, Integer> sameFreq = freqs.poll();
        sb.append(sameFreq.getKey());
        sameFreq.setValue(sameFreq.getValue() - 1);
        freqs.offer(sameFreq);
      }
    }
    return sb.toString();
  }
}
