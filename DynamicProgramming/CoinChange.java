package DynamicProgramming;
import java.util.Arrays;


class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length ;
        int [][] dp = new int [n][amount+1];
        for (int [] row : dp ){
            Arrays.fill(row , -1 );
        }

        int ans = solve(n-1 , amount , coins , dp);
        return (ans >= (int) 1e9) ? -1 : ans;
        
    }

    private int solve ( int i , int target , int [] coins , int [][] dp){
        if (target ==0){
            return 0;
        }
          if (i < 0) return (int) 1e9;        
          if ( dp[i][target] != -1){
            return dp[i][target];
          }

          int nonTake = 0 + solve(i-1 , target, coins , dp);
          int take = (int)1e9;
          if (coins[i] <= target){
            take = 1+ solve (i , target-coins[i] , coins , dp);
          }

          return dp[i][target] = Math.min(take , nonTake );
    }
}