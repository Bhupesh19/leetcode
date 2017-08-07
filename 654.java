public class Solution {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return constructTree(nums, 0, nums.length - 1);  
  }

  private TreeNode constructTree(int[] nums, int low, int high) {
    int rv = findMax(nums, low, high);
    if(rv == -1) return null;
    TreeNode root = new TreeNode(nums[rv]);
    root.left = constructTree(nums, low, rv - 1);
    root.right = constructTree(nums, rv + 1, high);
    return root;
  }

  private int findMax(int[] nums, int low, int high) {
    int index = -1;
    int max = Integer.MIN_VALUE;
    for(int i = low; i <= high; i++) {
      if(nums[i] > max) {
        index = i;
        max = nums[i];
      }
    }
    return index;
  }
}
