public class Solution {
 
  List<TreeNode> res = new ArrayList<>(); 
 
  public List<TreeNode> generateTrees(int n) {
    if(n == 0) {
      return res;
    }
    Set<Integer> nums = new HashSet<>();
    generate(null, nums, 0, n);
    return res;
  }
  
  private void generate(TreeNode node, Set<Integer> nums, int level, int n) {
    if(level == n) {
      TreeNode root = copyTree(node);
      res.add(root);
      return;
    }
    for(int i = 1; i <= n; i++) {
      if(!nums.contains(i)) {
        node = insertNode(node, i);
        nums.add(i);
        generate(node, nums, level+1, n);
        node = removeNode(node, i);
        nums.remove(i); 
      }
    }
  }
 
  private TreeNode insertNode(TreeNode root, int value) {
    TreeNode node = new TreeNode(value);
    if(root == null) {
      return node;
    }
    TreeNode q = root;
    TreeNode p = null;
    while(q != null) {
      if(value > q.val) {
        p = q;
        q = q.right;
      } else {
        p = q;
        q = q.left;
      } 
    }
    if(value > p.val) {
      p.right = node; 
    } else {
      p.left = node;
    }
    return root;
  }

  private TreeNode removeNode(TreeNode root, int value) {
    if(root.val == value) {
      return null;
    }
    TreeNode q = root;
    TreeNode p = null;
    while(q != null) {
      if(value > q.val) {
        p = q;
        q = q.right;
      } else if(value < q.val) {
        p = q;
        q = q.left;
      } else {
        if(p.left == q) {
          p.left = null;
        } else {
          p.right = null;
        }
        break; 
      }
    }
    return root;  
  }

  private TreeNode copyTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode copied = new TreeNode(root.val);
    copied.left = copyTree(root.left);
    copied.right = copyTree(root.right);
    return copied;
  } 
}
