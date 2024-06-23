package Recursion;

public class knapsack {
    public int maxProfit(int n,int[] weights, int cap,int[] prices) {
        if(n == 0 || cap == 0) {
           return 0; 
        }

        int inc = Integer.MAX_VALUE;
        int exc = Integer.MAX_VALUE;
        if(weights[n-1] <= cap) {
            inc = prices[n-1] + maxProfit(n-1, weights, cap-weights[n-1], prices);
        }
        exc = maxProfit(n-1, weights, cap, prices);
        return Math.max(inc, exc);
    }
    
}
