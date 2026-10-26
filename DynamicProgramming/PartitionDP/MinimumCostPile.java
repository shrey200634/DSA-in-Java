package DynamicProgramming.PartitionDP;

import java.util.Arrays;

public class MinimumCostPile {

    class Solution {
    public int mergeStones(int[] stones, int k) {
         int n = stones.length ;
         int [][] dp = new int[n][n];
         for ( int [] row : dp ){
            Arrays.fill(row , -1 );
         }
         int [] prefix = new int[n+1];

         if ( (n-1) % (k-1) !=0){
            return -1 ;
         }
         
         for ( int i =0 ; i<n ; i++){
            prefix[i+1] = prefix[i] + stones[i];
         }
         return solve ( 0,n-1,k, prefix , dp);
    }
    private int solve ( int i , int j , int k  ,  int [] prefix, int [][] dp ){
       if ( i ==j){
        return 0 ;
       }
       if ( dp[i][j] != -1){
        return dp[i][j];
       }

       int minCost = Integer.MAX_VALUE;

       for ( int mid = i ; mid < j ; mid += k-1){
       int cost=  solve(i , mid , k  , prefix, dp) +  solve(mid+1 , j , k , prefix, dp);
       minCost = Math.min(minCost , cost );
       }
       if ((j-i) %(k-1) ==0 ){
        minCost += prefix[j+1] - prefix[i];
       }

      return dp[i][j] = minCost ;
    }
}
    
}
