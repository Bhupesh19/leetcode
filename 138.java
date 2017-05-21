public class Solution {
  public RandomListNode copyRandomList(RandomListNode head) {
    if(head == null) {
      return null;
    }
    Map<RandomListNode, RandomListNode> nodes = new HashMap<>();
    RandomListNode curr = head;
    while(curr != null) {
      nodes.put(curr, new RandomListNode(curr.label));
      curr = curr.next; 
    }
    curr = head;
    while(curr != null) {
      nodes.get(curr).next = nodes.get(curr.next);
      if(curr.random != null) {
        nodes.get(curr).random = nodes.get(curr.random);
      }
      curr = curr.next;
    }
    return nodes.get(head);
  }
}
