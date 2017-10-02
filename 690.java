class Solution {
  public int getImportance(List<Employee> employees, int id) {
    int importance = 0;
    for(int em : employees.get(id - 1).subordinates) {
      importance += getImportance(employees, em);
    }
    return importance + employees.get(id - 1).importance;
  }
}
