package DynamicProgramming;

import java.util.*;

public class rodCutting {
    //TOP DOWN RECURSIVE
    public int maxRev(int[] rodSizes, int[] prices) {
        int res = recursiveHelper(rodSizes, prices, rodSizes.length-1);
        return res;
    }

    public int recursiveHelper(int[] rodSizes, int[] prices, int idx) {
        if(idx == 0) {
            return 0;
        }
        int maxProf = Integer.MIN_VALUE;
        for(int i=1;i<rodSizes.length;i++) {
            maxProf = Math.max(maxProf, prices[i] + recursiveHelper(rodSizes, prices, idx-i));
        }

        return maxProf;
    }

    //TOP DOWN MEMOISED
    public int maxRevmem(int[] rodSizes, int[] prices) {
        int [] dp = new int[rodSizes.length];
        Arrays.fill(dp, -1);
        int res = recursiveHelpermem(rodSizes, prices, rodSizes.length-1,dp);
        return res;
    }

    public int recursiveHelpermem(int[] rodSizes, int[] prices, int idx, int [] dp) {
        if(idx == 0) {
            return 0;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        int maxProf = Integer.MIN_VALUE;
        for(int i=1;i<rodSizes.length;i++) {
            maxProf = Math.max(maxProf, prices[i] + recursiveHelpermem(rodSizes, prices, idx-i,dp));
            dp[idx] = maxProf;
        }

        return dp[idx];
    }


    //BOTTOM UP
    public int maxRevBU(int[] rodSizes, int[] prices) {
        int [] dp = new int[rodSizes.length];
        Arrays.fill(dp, 0);
        for(int j=1;j<rodSizes.length;j++) {
            int max = Integer.MIN_VALUE;
            for(int i=0;i<j;i++) {
                max = Math.max(max, prices[i]+ rodSizes[j-i]);
            }
            rodSizes[j] = max;
        }
        return rodSizes[rodSizes.length];
    }


    //PATH RECORDING
    public int maxRevBUPR(int[] rodSizes, int[] prices) {
        int [] dp = new int[rodSizes.length];
        int [] s = new int[rodSizes.length];
        Arrays.fill(dp, 0);
        for(int j=1;j<rodSizes.length;j++) {
            int max = Integer.MIN_VALUE;
            for(int i=0;i<j;i++) {
                if(max < prices[i] + rodSizes[j-i]) {
                    max = Math.max(max, prices[i]+ rodSizes[j-i]);
                    s[j] = i;
                }
            }
            rodSizes[j] = max;
        }

        //s has the path or choices done 
        return rodSizes[rodSizes.length];
    }
    

    
}
