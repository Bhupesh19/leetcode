class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] jobs = new int[26];
    for (char c : tasks) {
      jobs[c - 'A']++;
    }
    Arrays.sort(jobs);
    int lastIndex = jobs.length - 1;
    int count = (jobs[lastIndex] - 1) * (n + 1) + 1;
    for (int i = jobs.length - 2; i >= 0; i--) {
      if (jobs[i] == jobs[lastIndex]) {
        count++;
      }
    }
  return Math.max(tasks.length, count);
  }
}
