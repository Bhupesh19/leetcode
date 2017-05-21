public class Solution {

  private Map<Integer, RandomListNode> nodes = new HashMap<>();

  public RandomListNode copyRandomList(RandomListNode head) {
    if(head == null) {
      return null;
    }
    RandomListNode newHead = null;
    RandomListNode random = null;
    if(!nodes.containsKey(head.label)) {
      newHead = new RandomListNode(head.label);
      nodes.put(head.label, newHead);
    } else {
      newHead = nodes.get(head.label);
    }
    if(head.random != null) {
      if(!nodes.containsKey(head.random.label)) {
        random = new RandomListNode(head.random.label);
        nodes.put(head.random.label, random);
      } else {
        random = nodes.get(head.random.label);
      }
    }
    newHead.random = random;
    newHead.next = copyRandomList(head.next);
    return newHead;
  }
}
