public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        if(N == 0) return 0;
        int[][][] p = new int[m][n][N];
        p[i][j][0] = 1;
        for(int k = 0; k < m; k++) {
            for(int l = 0; l < n; l++) {
                for(int r = 1; r < N; r++) {
                    if(k - 1 >= 0) p[k][l][r] += p[k - 1][l][r - 1];
                    if(k + 1 < m) p[k][l][r] += p[k + 1][l][r - 1];
                    if(l - 1 >= 0) p[k][l][r] += p[k][l - 1][r - 1];
                    if(l + 1 < n) p[k][l][r] += p[k][l + 1][r - 1];
                    p[k][l][r] %= 1000000007;
                }
            }
        }
        int sum = 0;
        for(int r = 0; r < N; r++) {
            for(int k = 0; k < m; k++) {
                sum += p[k][0][r];
                sum += p[k][n - 1][r];
            }
            for(int l = 0; l < n; l++) {
                sum += p[0][l][r];
                sum += p[m - 1][l][r];
            }
            sum %= 1000000007;
        }
        return sum;
    }
}
