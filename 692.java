class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    // use a map to store the pair (word, occurs)
    // put all map entries into a priority queue (min heap), in which the priority is determined by the freqs
    // set the cap of the heap as k + 1
    // when the cap is reached, always poll the root element
    // poll every element within the queue, reverse the list and return them
    List topk = new ArrayList();
    Map<String, Integer> occurs = new HashMap();
    for (String word : words) {
      occurs.put(word, occurs.getOrDefault(word, 0) + 1);
    }
    PriorityQueue<Map.Entry<String, Integer>> freqs = new PriorityQueue<>(k + 1, (a, b) -> {
      if (a.getValue() - b.getValue() != 0) {
        return a.getValue() - b.getValue();
      }
      return b.getKey().compareTo(a.getKey());
    });
    for (Map.Entry entry : occurs.entrySet()) {
      freqs.offer(entry);
      if (freqs.size() > k) {
        freqs.poll();
      }
    }
    while (freqs.size() > 0) {
      topk.add(freqs.poll().getKey());
    }
    Collections.reverse(topk);
    return topk;
  }
}
