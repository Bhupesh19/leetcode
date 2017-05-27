public class Solution {
    
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    ArrayList[] cs = new ArrayList[numCourses];
    for(int i = 0; i < numCourses; i++) {
      cs[i] = new ArrayList<Integer>();
    }
    for(int i = 0; i < prerequisites.length; i++) {
      cs[prerequisites[i][0]].add(prerequisites[i][1]);
    }
    boolean[] traversed = new boolean[numCourses];
    for(int i = 0; i < numCourses; i++) {
      if(hasLoop(cs, traversed, i)) {
        return false;
      }
    }
    return true;
  }
 
  private boolean hasLoop(ArrayList[] cs, boolean[] traversed, int curr) {
    if(traversed[curr]) {
      return true; 
    }
    traversed[curr] = true;
    for(int i = 0; i < cs[curr].size(); i++) {
      int pre = (int) cs[curr].get(i);
      if(hasLoop(cs, traversed, pre)) {
        return true;
      }
    }
    traversed[curr] = false;
    return false;
  }
}
