package DynamicProgramming.Stocks;

public class bestTimeToBuyAStock {


    public int maxProfit(int[] stocks) {
        if(stocks.length == 0) {
            return 0;
        }

        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;

        for(int n : stocks) {
            minPrice = Math.min(minPrice, n);
            maxProfit = Math.max(maxProfit, n - minPrice);
        }

        return maxProfit;
    }
    
    
}
