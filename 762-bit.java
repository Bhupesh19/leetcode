class Solution {
  public int countPrimeSetBits(int L, int R) {
    Integer[] ps = new Integer[]{ 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
    Set<Integer> primes = new HashSet<Integer>(Arrays.asList(ps));
    int counts = 0;
    for (int i = L; i <= R; i++) {
      int cnt = 0;
      for (int num = i; num > 0; num >>= 1) {
        cnt += num & 1;
      }
      counts = (primes.contains(cnt)) ? counts + 1 : counts; 
    }
    return counts;
  }
}
