class Solution {
  public List<List<String>> findDuplicate(String[] paths) {
    Map<String, List<String>> map = new HashMap<>();
    List<List<String>> dups = new ArrayList<>();
    for (String s : paths) {
      String[] str = s.split(" ");
      String dir = str[0];
      for (int i = 1; i < str.length; i++) {
        int left = str[i].indexOf('(');
        int right = str[i].indexOf(')');
        String content = str[i].substring(left + 1, right);
        String file = dir + "/" + str[i].substring(0, left);
        if (!map.containsKey(content)) {
          map.put(content, new ArrayList<String>());
        } 
        map.get(content).add(file);  
      }
    }
    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      if (entry.getValue().size() >= 2) {
        dups.add(new ArrayList<String>());
        for (String s : entry.getValue()) {
          dups.get(dups.size() - 1).add(s);
        }
      }
    }
    return dups;
  }
}
