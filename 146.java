public class LRUCache {
  
  private int cap;
  private DoublyLinkedList l;
  private Map<Integer, Node> map;

  public LRUCache(int capacity) {
    cap = capacity;
    l = new DoublyLinkedList();
    map = new HashMap<Integer, Node>();
  }
   
  public int get(int key) {
    if(map.containsKey(key)) {
      l.removeNode(map.get(key));
      l.addNode(map.get(key));
      return map.get(key).value;
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    Node node = new Node(key, value); 
    if(map.containsKey(key)) {
      l.removeNode(map.get(key));
    }
    l.addNode(node);
    map.put(key, node);
    if(map.size() > cap) {
      map.remove(l.tail.prev.key);
      l.removeNode(l.tail.prev);
    } 
  }
}

class Node {
  int key;
  int value;
  Node prev;
  Node succ;

  Node() {}
  
  Node(int key, int value) {
    this.key = key;
    this.value = value;
  }
}

class DoublyLinkedList {
  Node head;
  Node tail;
  
  DoublyLinkedList() {
    this.head = new Node();
    this.tail = new Node();
    this.head.succ = this.tail;
    this.tail.prev = this.head;
  }

  void addNode(Node node) {
    node.succ = this.head.succ;
    node.prev = this.head;
    node.succ.prev = node;
    this.head.succ = node;
  }

  void removeNode(Node node) {
    node.prev.succ = node.succ;
    node.succ.prev = node.prev; 
  }
}
