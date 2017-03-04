public class Solution {
  public String simplifyPath(String path) {
    String[] dirs = path.split("/");
    for(int i = 0; i < dirs.length; i++) {
      if(dirs[i].equals(".")) {
        dirs[i] = "";
      }
      if(dirs[i].equals("..")) {
        dirs[i] = "";
        for(int j = i-1; j >= 0; j--) {
          if(!dirs[j].equals("")) {
            dirs[j] = "";
            break;
          }
        }
      }
    }
    StringBuilder res = new StringBuilder("");
    for(int i = 0; i < dirs.length; i++) {
      if(!dirs[i].equals("")) {
        res.append("/").append(dirs[i]);  
      }
    }
    String str = res.toString();
    return (str.length() == 0) ? "/" : str;
  }
}
