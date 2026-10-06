package DynamicProgramming;

public class MaxProfitII {




// tabulation solution 
    class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length ;
        int [][] dp = new int [n+1][2];

        for ( int i =n-1 ; i>=0 ; i--){
            for ( int buy =0 ; buy<=1 ; buy++){
                if (buy ==1 ){
                    dp[i][buy] = Math.max(-prices[i] + dp[i+1][0] , dp[i+1][1]);
                }else {
                    dp[i][buy] = Math.max(prices[i] + dp[i+1][1]  , dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
        
    }
}



// space optimisation 
    public int maxProfit(int[] prices) {

        int n = prices.length ;
        int nextBuy =0 ;
        int nextSell =0 ;

        for ( int i = n-1 ; i>=0 ; i--){
            int currBuy = Math.max(-prices[i] + nextSell , nextBuy );
            int currSell = Math.max(prices[i] + nextBuy , nextSell);

            nextBuy = currBuy ;
            nextSell = currSell ;
        }
        return nextBuy ;
        
    }
}
    

