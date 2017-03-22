public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    while(head != null) {
      if(!map.containsKey(head.val)) {
        map.put(head.val, 1);
      } else { 
        map.put(head.val, map.get(head.val) + 1);
      }
      head = head.next;
    }
    ListNode newHead = new ListNode(0);
    ListNode q = newHead;
    for(Integer cand : map.keySet()) {
      if(map.get(cand) == 1) {
        q.next = new ListNode(cand);
        q = q.next;
      }
    }
    return newHead.next;  
  }
}
