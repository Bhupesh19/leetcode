public class Solution {

  private Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if(node == null) {
      return null;
    }
    Queue<UndirectedGraphNode> queue = new LinkedList<>();
    queue.add(node);
    while(!queue.isEmpty()) {
      UndirectedGraphNode curr = queue.remove();
      map.put(curr, new UndirectedGraphNode(curr.label));
      for(UndirectedGraphNode neighbor: curr.neighbors) {
        if(!map.containsKey(neighbor)) {
          queue.add(neighbor);
        }
      }
    }
    for(UndirectedGraphNode curr : map.keySet()) {
      for(UndirectedGraphNode neighbor : curr.neighbors) {
        map.get(curr).neighbors.add(map.get(neighbor)); 
      }
    }
    return map.get(node);
  }
}
