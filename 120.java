public class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    int[] res = new int[triangle.size()];
    if(triangle.size() == 0) {
      return 0;
    }
    res[0] = triangle.get(0).get(0);
    for(int i = 1; i < triangle.size(); i++) {
      for(int j = i; j >= 0; j--) {
        if(j >= triangle.get(i-1).size()) {
          res[j] = res[j-1] + triangle.get(i).get(j);
        } else if(j == 0) {
          res[j] = res[j] + triangle.get(i).get(j);
        } else {
          res[j] = (res[j-1] < res[j]) ? res[j-1] + triangle.get(i).get(j) : res[j] + triangle.get(i).get(j); 
        }
      }
    }
    Arrays.sort(res);
    return res[0];
  }
}
