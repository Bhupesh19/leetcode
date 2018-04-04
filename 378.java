class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    // should maintain a max heap with capacity of k + 1
    // add all matrix elements to this heap
    // once the capacity is full, remove the root element, in this case, we always keep k (or less than k) smallest elements from the first element to the current element within the list
    // if we can gurantee that the size of all elments is larger than or equal to k
    // we poll the root element, which is also our target value
        
    int n = matrix.length;
    PriorityQueue<Integer> smallests = new PriorityQueue<>(k + 1, (a, b) -> b - a);
        
    // O(n*n*logn)
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        smallests.offer(matrix[i][j]);
        if (smallests.size() > k) {
          smallests.poll();
        }
      }
    }
    return smallests.poll();
  }
}
