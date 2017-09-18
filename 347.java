class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int num : nums) {
      if(map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
      pq.add(entry);
    }
    List<Integer> res = new ArrayList<>();
    for(int i = 0; i < k; i++) {
      res.add(pq.poll().getKey());  
    }
    return res;
  }
}
