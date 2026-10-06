package DynamicProgramming;

import java.util.Arrays;

public class ButAndSellStockIIIHard {




    class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length ;
        int [][][] dp = new int [n][2][3];

        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }

        return solve (0 , 1,2,prices,dp);

    }

    private int solve ( int i , int buy ,int cap ,  int [] nums , int [][][] dp ){
         int n = nums.length ;
        

        if ( i ==n || cap ==0 ){
            return 0 ;
        }
        if (dp[i][buy][cap] != -1 ){
            return dp[i][buy][cap] ;
        }

        if (buy ==1 ){
            dp[i][buy][cap] = Math.max(-nums[i] + solve(i+1 , 0 , cap , nums,dp) , 0+ solve(i+1 , 1 , cap , nums , dp));
        }else {
            dp[i][buy][cap] = Math.max(nums[i] + solve(i+1 , 1 , cap-1 , nums , dp) , 0+ solve(i+1 , 0 , cap , nums , dp));
        }

        return dp[i][buy][cap];

    }
}
    
}
