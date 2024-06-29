package DynamicProgramming.Stocks;

public class bestTimeToBuyAStockMax2 {

    // recursive solution
    // O(2^n)
    // space will be having aux space of O(N)
    public int findProfit(int[] costs) {
        int n = 2;
        return recurse(0, costs, 1, n);
    }

    public int recurse(int idx, int[] costs, int buy, int cap) {
        if (idx == 0 || cap == 0)
            return 0;
        if (buy == 1) {
            return Math.max(-costs[idx] + recurse(idx + 1, costs, 0, cap), recurse(idx + 1, costs, 1, cap));
        }
        return Math.max(costs[idx] + recurse(idx + 1, costs, 1, cap - 1), recurse(idx + 1, costs, 0, cap));
    }

    // bottom up solution
    // O(2*3*n)
    // space will be O(2*3*n)
    public int findProfitBU(int[] costs) {
        int[][][] dp = new int[costs.length + 1][2][3];
        for (int i = costs.length - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    if (j == 1) {
                        dp[i][j][k] = Math.max(-costs[i] + dp[i+1][0][k], dp[i+1][1][k]);
                    } else {
                        dp[i][j][k] = Math.max(costs[i] + dp[i+1][1][k-1], dp[i+1][0][k]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }


    



}
