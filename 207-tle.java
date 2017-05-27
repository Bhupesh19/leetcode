public class Solution {
    
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    ArrayList[] cs = new ArrayList[numCourses];
    for(int i = 0; i < numCourses; i++) {
      cs[i] = new ArrayList<Integer>();
    }
    for(int i = 0; i < prerequisites.length; i++) {
      cs[prerequisites[i][0]].add(prerequisites[i][1]);
    }
    for(int i = 0; i < numCourses; i++) {
      Set<Integer> traversed = new HashSet<>();
      traversed.add(i);
      if(hasLoop(cs, traversed, i)) {
        return false;
      }
    }
    return true;
  }
 
  private boolean hasLoop(ArrayList[] cs, Set<Integer> traversed, int curr) {
    if(cs[curr].size() == 0) {
      return false;
    }
    for(int i = 0; i < cs[curr].size(); i++) {
      int pre = (int) cs[curr].get(i);
      if(traversed.contains(pre)) {
        return true;
      }
      traversed.add(pre);
      if(hasLoop(cs, traversed, pre)) {
        return true;
      }
      traversed.remove(pre);
    }
    return false;
  }
}
