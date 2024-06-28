package DynamicProgramming.Grids;

import java.util.Arrays;

public class countUniquePaths {
    //Recursion O(2^m*n)
    //space will be O(path length)
    public int uniquePaths(int m, int n) {
        return recur(m - 1, n - 1);
    }

    public int recur(int m, int n) {
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        int left = recur(m - 1, n);
        int right = recur(m, n - 1);
        return left + right;
    }

    // Memoised solution
    public int uniquePathsMEM(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] dpr : dp) {
            Arrays.fill(dpr, -1);
        }
        return recurMEM(m-1,n-1, dp);
    }

    public int recurMEM(int m, int n, int[][] dp) {
        if(m == 0 && n == 0) {
            return 1;
        }
        if(m < 0 || n <0) {
            return 0;
        }

        if(dp[m][n]!=-1) {
            return dp[m][n];
        }
        int left = recurMEM(m-1,n,dp);
        int right = recurMEM(m,n-1, dp);
        return dp[m][n]= left + right;
    }


    // TAB solution
    public int uniquePathsBU(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] dpr : dp) {
            Arrays.fill(dpr, 0);
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if( i== 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = 0;
                    int left = 0;
                    if(i > 0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up + left;
                }

            }
        }

        return dp[m-1][n-1];
    }


    // TAB SO solution
    public int uniquePathsBUSO(int m, int n) {
        int[] prev = new int[n];
        Arrays.fill(prev, 0);
        for(int i=0;i<m;i++) {
            int[] cur = new int[n];
            Arrays.fill(cur, 0);
            for(int j=0;j<n;j++) {
                if( i== 0 && j == 0) {
                    cur[j] = 1;
                } else {
                    int up = 0;
                    int left = 0;
                    if(i > 0) up = prev[j];
                    if(j>0) left = cur[j-1];
                    cur[j] = up + left;
                }

            }
            prev = cur;
        }

        return prev[n-1];
    }







    
}
