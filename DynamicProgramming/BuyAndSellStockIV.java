package DynamicProgramming;

public class BuyAndSellStockIV {



    class Solution {
    public int maxProfit(int k, int[] prices) {

        int n = prices.length ;
        if (n==0 || k==0) return 0 ;

        if (k>=n/2){
            int maxProfit =0 ;
            for ( int i =1 ; i<n ; i++){
                if (prices[i] > prices[i-1]){
                    maxProfit += prices[i] -prices[i-1];
                }
            }
            return maxProfit ;

        }

        int [][][] dp = new int [n+1][2][k+1];

        for ( int i = n-1 ; i>=0 ; i--){
            for (int buy =0 ; buy <=1; buy ++){
                for (int tran =0 ; tran < k ; tran ++){
                 if (buy ==1){
                    dp[i][buy][tran]= Math.max(-prices[i] + dp[i+1][0][tran] , 0+ dp[i+1][1][tran]);
                 }else {
                    dp[i][buy][tran] = Math.max(prices[i] + dp[i+1][1][tran+1] , 0+ dp[i+1][0][tran]);
                 }

                }
            }
        }
        return dp[0][1][0];
        
    }
}
    
}
