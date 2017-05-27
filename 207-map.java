public class Solution {
 
  private Map<Integer, ArrayList<Integer>> map = new HashMap<>();  
   
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    for(int i = 0; i < numCourses; i++) {
      map.put(i, new ArrayList<Integer>());
    }
    for(int i = 0; i < prerequisites.length; i++) {
      map.get(prerequisites[i][0]).add(prerequisites[i][1]);
    }
    boolean[] traversed = new boolean[numCourses];
    for(int i = 0; i < numCourses; i++) {
      if(hasLoop(traversed, i)) {
        return false;
      }
    }
    return true;
  }
 
  private boolean hasLoop(boolean[] traversed, int curr) {
    if(traversed[curr]) {
      return true; 
    }
    traversed[curr] = true;
    for(int pre : map.get(curr)) {
      if(hasLoop(traversed, pre)) {
        return true;
      }
    }
    traversed[curr] = false;
    return false;
  }
}
