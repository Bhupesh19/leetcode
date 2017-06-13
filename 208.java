class TrieNode {
  
  public char key;
  public boolean isWord;
  public TrieNode[] children = new TrieNode[26];
  
  public TrieNode() {}

  public TrieNode(char c) {
    key = c;
  }
}

public class Trie {

  private TrieNode root; 

  public Trie() {
    root = new TrieNode(' ');
  }

  public void insert(String word) {
    TrieNode cur = root;
    for(int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if(cur.children[c - 'a'] == null) {
        cur.children[c - 'a'] = new TrieNode(c);
      }
      cur = cur.children[c - 'a'];
    }
    cur.isWord = true;
  }

  public boolean search(String word) {
    TrieNode curr = root;
    for(int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if(curr.children[c - 'a'] == null) {
        return false;
      }
      curr = curr.children[c - 'a'];
    }
    return curr.isWord;
  }

  public boolean startsWith(String prefix) {
    TrieNode curr = root;
    for(int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if(curr.children[c - 'a'] == null) {
        return false;
      }
      curr = curr.children[c - 'a'];
    }
    return true;
  }
}
