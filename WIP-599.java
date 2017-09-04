class Solution {
  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map = new HashMap<>();
    for(int i = 0; i < list1.length; i++) {
      map.put(list1[i], i);
    }
    for(int i = 0; i < list2.length; i++) {
      if(map.containsKey(list2[i])) {
        map.put(list2[i], map.get(list2[i]) + i);
      } else {
        map.put(list2[i], i); 
      }
    }
  }
}
