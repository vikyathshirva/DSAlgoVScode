package DynamicProgramming;

import java.util.*;

public class frogJumps {

    public int find(int idx, int[] hieghts, int[] dp) {
        if(idx == 0) {
            return 0;
        }
        if(dp[idx] != -1) {
            return dp[idx];
        }
        int left = find(idx-1, hieghts, dp)  + Math.abs(hieghts[idx] - hieghts[idx - 1]);
        int right = Integer.MAX_VALUE;
        if(idx > 1) {
            right = find(idx-2, hieghts,dp)  + Math.abs(hieghts[idx] - hieghts[idx-2]);
        }
        return dp[idx] = Math.min(left, right);
    }


    public int jumps(int n, int[] hieghts) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return find(n, hieghts, dp);
    }


    public int tabJumps(int n, int[] heights) {
        int[] dp = new int[n];
        dp[0] = 0;
        Arrays.fill(dp, 0);
        for(int i=1;i<n;i++) {
            int fs = dp[i-1] + Math.abs(heights[i]-heights[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1) {
                ss = dp[i-2] + Math.abs(heights[i] - heights[i-1]);
            }
            dp[i] = Math.min(fs,ss);
        }
        return dp[n-1];
    }
    
}
