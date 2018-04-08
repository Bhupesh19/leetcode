class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> nodes = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (ListNode node : lists) {
      while (node != null) {
        nodes.offer(node);
        node = node.next;
      }
    }
    if (nodes.isEmpty()) {
      return null;
    }
    ListNode newHead = nodes.poll();
    ListNode p = newHead;
    while (!nodes.isEmpty()) {
      p.next = nodes.poll();
      p = p.next;
      if (nodes.size() == 0) {
        p.next = null;
      }
    }
    return newHead;
  }
}
