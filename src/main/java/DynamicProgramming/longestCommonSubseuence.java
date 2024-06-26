package DynamicProgramming;

import java.util.*;
/**
 * for 2 string comparisong use 2 indexes and compare recursively
 * very straight forward 
 */
public class longestCommonSubseuence {


    public int findLCS(String a, String b) {
        return finder(a,b,a.length()-1, b.length()-1);
    }


    public int finder(String a, String b, int len1, int len2) {
        if(len1 < 0 || len2 < 0) {
            return 0;
        }
        if(a.charAt(len1) == b.charAt(len2)) {
            return 1 + finder(a, b, len1-1, len2-1);
        }

        return Math.max(finder(a, b, len1-1, len2), finder(a, b, len1, len2-1));
    }



    public int findLCSMEM(String a, String b) {
        int[][] dp = new int[a.length()][b.length()];
        for(int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }
        return finderMEM(a,b,a.length()-1, b.length()-1, dp);
    }


    public int finderMEM(String a, String b, int len1, int len2, int[][] dp) {
        if(len1 <0 || len2 < 0) {
            return 0;
        }
        if(dp[len1][len2]!= -1) {
            return dp[len1][len2];
        }

        if(a.charAt(len1) == b.charAt(len2)) {
            dp[len1][len2] = 1+ finderMEM(a,b,a.length()-1, b.length()-1, dp);
        }

        return dp[len1][len2];
    }



    public int findLCSBU(String a, String b) {
        int[][] dp = new int[a.length()][b.length()];
        for(int i=0;i<=a.length();i++) {
            dp[i][0] = 0;
        }
        for(int j=0;j<=b.length();j++) {
            dp[0][j] = 0;
        }

        for(int i=1;i<=a.length();i++) {
            for(int j=1;j<=b.length();j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1]; 
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    public int findLCSBUSO(String a, String b) {
        int[] cur = new int[b.length()];
        int[] prev = new int[b.length()];
        for(int i=0;i<=b.length();i++) {
            cur[i] = 0;
            prev[i] = 0;
        }

        for(int i=1;i<=a.length();i++) {
            for(int j=1;j<=b.length();j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    cur[j] = 1 + prev[j-1]; 
                } else {
                    cur[j] = Math.max(cur[j], cur[j-1]); 
                }
                prev = cur;
            }
        }
        return prev[b.length()];
    }
    
}
