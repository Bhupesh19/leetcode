public class Solution {
  public RandomListNode copyRandomList(RandomListNode head) {
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode p = head;  
    RandomListNode sentinel = new RandomListNode(0);
    RandomListNode q = sentinel;
    while(p != null) {
      RandomListNode copy = null;
      RandomListNode rand = null;
      if(map.containsKey(p)) {
        copy = map.get(p);
      } else {
        copy = new RandomListNode(p.label);
        map.put(p, copy);
      }
      if(p.random != null) {
        if(map.containsKey(p.random)) {
          rand = map.get(p.random);
        } else {
          rand = new RandomListNode(p.random.label);
          map.put(p.random, rand);
        }
      }
      copy.random = rand;
      q.next = copy;
      q = q.next;
      p = p.next;
    }
    return sentinel.next;
  }
}
