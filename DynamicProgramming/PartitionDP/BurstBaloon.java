package DynamicProgramming.PartitionDP;

import java.util.Arrays;

class BurstBaloon {
    public int maxCoins(int[] nums) {

        int n = nums.length ;
        int [] bal = new int[n+2];

        bal[0] =1 ;
        bal[n+1] =1 ;

        for (int i = 0; i < nums.length; i++) {
        bal[i + 1] = nums[i]; 
    }

    int [][] dp  = new int [n+2][n+2];

    for ( int[] row : dp){
        Arrays.fill(row ,-1 );
    }

    return solve ( 1 , n , dp , bal );

        
    }

    private int solve( int i , int j , int[][] dp , int [] nums ){
        if ( i>j) return 0 ;

        if (dp[i][j] != -1 ){
            return dp[i][j];
        }
        int maxCoin =0 ;
        for ( int k =i ; k<=j; k++){
            int cost = nums[i-1] * nums[k] * nums[j+1]
                       + solve(i , k-1 , dp , nums )
                       +solve(k+1 , j , dp , nums );

                maxCoin = Math.max(cost , maxCoin );
        }
        return dp[i][j] = maxCoin ;

    }





    class Solution {
    public int maxCoins(int[] nums) {

        int n = nums.length ;
        int [] bal = new int[n+2];

        bal[0] =1 ;
        bal[n+1] =1 ;

        for (int i = 0; i < nums.length; i++) {
        bal[i + 1] = nums[i]; 
    }

    int [][] dp  = new int [n+2][n+2];

        for ( int i =n ; i>=1 ; i -- ){
            for ( int j =i ; j <= n ; j++){
                 int maxCoin  =0 ;

                 for ( int k =i ; k<=j; k++){
                    int cost = bal[i-1] * bal[k] * bal[j+1]
                       +dp[i][k-1]
                       +dp[k+1][j];

                maxCoin = Math.max(cost , maxCoin );
        }
                    dp[i][j] = maxCoin ;

            }
        }
        return dp[1][n];
        
    }
}
}