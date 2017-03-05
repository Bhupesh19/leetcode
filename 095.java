public class Solution {
 
  List<TreeNode> res = new ArrayList<>(); 
 
  public List<TreeNode> generateTrees(int n) {
    if(n == 0) {
      return res;
    }
    Set<Integer> nums = new HashSet<>();
    generate(new TreeNode(0), nums, 0, n);
    return res;
  }
  
  private void generate(TreeNode node, Set<Integer> nums, int level, int n) {
    if(level == n) {
      res.add(node);
      return;
    }
    for(int i = 1; i <= n; i++) {
      
    }
  } 
}
