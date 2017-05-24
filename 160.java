public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA == null || headB == null) {
      return null;
    }
    ListNode p = headA;
    ListNode q = headB;
    int visited = 0;
    while(p != q) {
      p = p.next;
      q = q.next;
      if(p == null || q == null) {
        if(visited >= 2) {
          return null;
        }
        p = (p == null) ? headB : p;
        q = (q == null) ? headA : q;
        visited++;
      }
    }
    return p;
  }
}
