class Solution {
  public String frequencySort(String s) {
    // use a map to store a key-value pair (char, occurences)
    // comparator: sort the map entries according to all these pairs
    // put all entries into a priority queue (max heap)
    // every time get the top element from the priority queue and append to the string builder
    if (s.length() == 0) {
      return "";
    }
    Map<Character, Integer> occurs = new HashMap<>();
        
    // O(n)
    for (char ch : s.toCharArray()) {
      occurs.put(ch, occurs.getOrDefault(ch, 0) + 1);
    }
    StringBuilder sb = new StringBuilder();
    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(occurs.size(), (a, b) -> b.getValue() - a.getValue());
        
    // O(n*logn)
    for (Map.Entry<Character, Integer> entry : occurs.entrySet()) {
      pq.offer(entry);
    }
        
    // O(n*logn)
    while (pq.size() > 0) {
      Map.Entry<Character, Integer> cur = pq.poll();
      for (int i = 0; i < cur.getValue(); i++) {
        sb.append(cur.getKey());
      }
    }
        
    return sb.toString();
  }
}
