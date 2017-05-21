public class Solution {

  private Map<RandomListNode, RandomListNode> nodes = new HashMap<>();

  public RandomListNode copyRandomList(RandomListNode head) {
    if(head == null) {
      return null;
    }
    RandomListNode newHead = null;
    RandomListNode random = null;
    if(!nodes.containsKey(head)) {
      newHead = new RandomListNode(head.label);
      nodes.put(head, newHead);
    } else {
      newHead = nodes.get(head);
    }
    if(head.random != null) {
      if(!nodes.containsKey(head.random)) {
        random = new RandomListNode(head.random.label);
        nodes.put(head.random, random);
      } else {
        random = nodes.get(head.random);
      }
    }
    newHead.random = random;
    RandomListNode p = head.next;
    RandomListNode q = newHead;
    while(p != null) {
      RandomListNode curr = null;
      RandomListNode rand = null;
      if(!nodes.containsKey(p)) {
        curr = new RandomListNode(p.label);
        nodes.put(p, curr);
      } else {
        curr = nodes.get(p);
      }
      if(p.random != null) {
        if(!nodes.containsKey(p.random)) {
          rand = new RandomListNode(p.random.label);
          nodes.put(p.random, rand);
        } else {
          rand = nodes.get(p.random);
        }
      }
      curr.random = rand;
      q.next = curr;
      p = p.next;
      q = q.next; 
    }
    return newHead;
  }
}
