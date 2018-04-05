class Solution {
  public int nthSuperUglyNumber(int n, int[] primes) {
    Arrays.sort(primes);
    PriorityQueue<Long> uglyNumbers = new PriorityQueue();
    uglyNumbers.offer((long) 1);
    for (int i = 1; i <= n; i++) {
      long cur = uglyNumbers.poll();
      for (int prime : primes) {
        uglyNumbers.offer(prime * cur);
      }
      while (!uglyNumbers.isEmpty() && uglyNumbers.peek() == cur) {
        uglyNumbers.poll();
      }
      if (i == n) {
        return (int) cur;
      }
    }
    throw new RuntimeException();       
  }
}
