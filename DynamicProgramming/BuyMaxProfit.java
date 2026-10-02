package DynamicProgramming;

import java.util.Arrays;

public class BuyMaxProfit {





    public int maxProfit(int[] prices) {

        int n = prices.length ;
        int [][] dp = new int [n][2];
        for ( int  [] row : dp ){
            Arrays.fill(row , -1 );

        }
        return maxP(0 , 1 , prices , n  , dp);
        
    }
    private int maxP( int i , int buy , int [] nums , int n  , int [][] dp ){
        if ( i == n) return 0 ;

       if ( dp[i][buy] != -1  ){
        return dp[i][buy];
       }
       
        if (buy ==1  ){
            dp[i][buy] = Math.max(-nums[i] + maxP(i+1 , 0 , nums , n , dp)  , 0 + maxP(i+1 , 1 , nums , n ,dp ));

        }else {
            dp[i][buy] = Math.max(nums[i] + maxP(i+1 ,1 ,nums ,n,dp)
                          ,0 + maxP(i+1 , 0 , nums , n ,dp));

        }
        return dp[i][buy];
    }
}
    

