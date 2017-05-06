public class Solution {
  public void connect(TreeLinkNode root) {
    List<List<TreeLinkNode>> res = new ArrayList<>();
    traverse(res, root, 0);
    for(List<TreeLinkNode> node : res) {
      for(int i = 0; i < node.size(); i++) {
        if(i == node.size() - 1) {
          node.get(i).next = null;
        } else {
          node.get(i).next = node.get(i+1);
        }
      }
    }
    return;
  }
    
  public void traverse(List<List<TreeLinkNode>> res, TreeLinkNode root, int height) {
    if(root == null) {
      return;
    }
    if(res.size() <= height) {
      res.add(new ArrayList<TreeLinkNode>());
    }
    res.get(height).add(root);
    traverse(res, root.left, height + 1);
    traverse(res, root.right, height + 1);
    return;
  }
}
