class MapSum {
  class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;
    int val;

    public TrieNode() {
      children = new HashMap<Character, TrieNode>();
      isWord = false;
      val = 0;
    }
  }
 
  TrieNode root;

  public MapSum() {
    root = new TrieNode();
  }

  public void insert(String key, int val) {
    TrieNode curr = root;
    for(char c : key.toCharArray()) {
      TrieNode next = curr.children.get(c);
      if(next == null) {
        next = new TrieNode();
        curr.children.put(c, next);
      }
      curr = next;
    }
    curr.isWord = true;
    curr.val = val;
  }

  public int sum(String prefix) {
    TrieNode curr = root;
    for(char c : prefix.toCharArray()) {
      TrieNode next = curr.children.get(c);
      if(next == null) {
        return 0;
      }
      curr = next;
    }
    return dfs(curr);
  }

  private int dfs(TrieNode root) {
    if(root == null) return 0;
    int sum = 0;
    for(char curr : root.children.keySet()) {
      sum += dfs(root.children.get(curr));
    }
    return sum + root.val;
  }

}
