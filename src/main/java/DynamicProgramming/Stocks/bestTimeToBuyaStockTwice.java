package DynamicProgramming.Stocks;

import java.util.*;

public class bestTimeToBuyaStockTwice {


    // recursive solution
    // O(2^n)
    // space would be stack space
    public int maxProfit(int[] costs) {
        return recurse(costs, 0, true);
    }


    public int recurse(int[] costs, int idx, boolean buy) {
        if(idx == costs.length) {
            return 0;
        }
        int profit=0;
        if(buy) {
            profit = Math.max(-costs[idx] + recurse(costs, idx+1, false), 0 + recurse(costs, idx+1, true));
        } else {
            profit = Math.max(costs[idx] + recurse(costs, idx+1,true),0 + recurse(costs, idx+1, false));
        }

        return profit;
    }


    // memoized solution
    // O(N*2)
    // space would be O(N*2) + aux stack space
    public int maxProfitMEM(int[] costs) {
        int[][] dp = new int[costs.length][2];
        for(int[] dpr : dp) Arrays.fill(dpr, -1);
        return recurseMEM(costs, 0, 0, dp);
    }


    public int recurseMEM(int[] costs, int idx, int buy, int[][] dp) {
        if(idx == costs.length) {
            return 0;
        }
        if(dp[idx][buy] != -1) return dp[idx][buy];
        int profit=0;
        if(buy == 1) {
            profit = Math.max(-costs[idx] + recurseMEM(costs, idx+1, 0, dp), 0 + recurseMEM(costs, idx+1, 1, dp));
        } else {
            profit = Math.max(costs[idx] + recurseMEM(costs, idx+1,1, dp),0 + recurseMEM(costs, idx+1, 0, dp));
        }

        return dp[idx][buy] = profit;
    }



    // TAB solution
    // O(2^n)
    public int maxProfitBU(int[] costs) {
        int[][] dp = new int[costs.length+1][2];
        for(int[] dpr : dp) Arrays.fill(dpr, 0);

        dp[costs.length][0] = 0;
        dp[costs.length][1] = 0;
        for(int i=costs.length-1;i >= 0; i--) {
            for(int j=0;j<1;j++) {
                int profit = 0;
                if(i == 0) {
                    profit = Math.max(-costs[i] + dp[i+1][0], dp[i+1][1]);
                } else {
                    profit = Math.max(costs[i]+ dp[i+1][1], dp[i+1][0]);
                }

                dp[i][j] = profit;
            }
        }

        return dp[0][1]; 
    }

    // TAB Space optimised solution
    // O(2^n)
    public int maxProfitBUSO(int[] costs) {
        int[] ahead = new int[2];
        int [] cur = new int[2];
        ahead[0] = 0;
        ahead[1] = 0;
        for(int i=costs.length-1;i >= 0; i--) {
            for(int j=0;j<1;j++) {
                int profit = 0;
                if(i == 0) {
                    profit = Math.max(-costs[i] + ahead[0], ahead[1]);
                } else {
                    profit = Math.max(costs[i]+ ahead[1], ahead[0]);
                }

                cur[j] = profit;
            }
            ahead = cur;
        }

        return cur[1]; 
    }




































    
}
