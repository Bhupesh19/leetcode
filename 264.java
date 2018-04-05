class Solution {
  public int nthUglyNumber(int n) {
    // create a min-heap to first store 1
    // every time pull a number out of the heap, also store num * 2, num * 3, num * 5
    // note that there might occur some dups, like 2 * 3 and 3 * 2, always the check the root value after each poll, and poll until there are no dups
    // it gurantees that every time we will poll the smallest number
    PriorityQueue<Long> uglyNumbers = new PriorityQueue();
    uglyNumbers.offer((long) 1);
    for (int i = 1; i <= n; i++) {
      long cur =  uglyNumbers.poll();
      uglyNumbers.offer(cur * 2);
      uglyNumbers.offer(cur * 3);
      uglyNumbers.offer(cur * 5);
      while (uglyNumbers.size() > 0 && uglyNumbers.peek() == cur) {
        uglyNumbers.poll();
      }
      if (i == n) {
        return (int) cur;
      }
    }
    // not reachable
    return -1;
  }
}

