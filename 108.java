public class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    return getTree(nums, 0, nums.length - 1);
  }
    
  private TreeNode getTree(int[] nums, int low, int high) {
    if(low > high) {
      return null;
    }
    int mid = (low + high) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = getTree(nums, low, mid - 1);
    root.right = getTree(nums, mid + 1, high);
    return root;
  }
}
