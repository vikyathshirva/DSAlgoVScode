package DynamicProgramming;

import java.util.*;


public class longestCommonSubstring {

    public int longestCommonFinder(String a, String b) {
        return finder(a,b,a.length(),b.length());
    }


    public int finder(String a, String b, int len1, int len2) {
        if(len1 < 0 || len2 < 0) {
            return 0;
        }

        if(a.charAt(len1) == b.charAt(len2)) {
            return 1 + finder(a, b, len1-1, len2-1);
        } else {
            return 0;
        }
    }



    public int longestCommonFinderBU(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[a.length()][b.length()];

        for(int [] dpRow : dp) {
            Arrays.fill(dpRow, 0);
        }

        for(int i=0;i<=m;i++) {
            dp[0][i] = 0;
        }

        for(int j=0;j<=n;j++) {
            dp[j][0] = 0;
        }

        int ans = 0;

        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans;

    }



    public int longestCommonFinderBUSO(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[] cur = new int[m];
        int[] prev = new int[m];

        int ans = 0;
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(a.charAt(i) == b.charAt(j)) {
                    cur[j] = 1 + prev[j-1];
                    ans = Math.max(ans, cur[j]);
                } else {
                    cur[j] = 0;
                }
                prev = cur;
            }
        }

        return ans;

    }




    
}
