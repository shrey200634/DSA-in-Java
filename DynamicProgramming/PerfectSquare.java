package DynamicProgramming;

import java.util.Arrays;

public class PerfectSquare {



    public int numSquares(int n) {

        int maxBase = (int) Math.sqrt(n);

        int [][]memo = new int  [maxBase+1][n+1];
        for (int [] row : memo ){
            Arrays.fill(row, -1);
        } 
        return solve (1,n,maxBase,memo);
        
    }

    private int solve (int i , int n , int maxBase , int [][] memo){
        if (n==0){
            return 0;
        }
        if (i> maxBase || i*i >n){
            return (int)1e9;
        }
      if (memo[i][n] != -1) return memo[i][n];

        int nonTake = solve (i+1 , n , maxBase , memo );
        int take = 1 + solve (i , n-(i*i) , maxBase , memo);

        return memo[i][n] = Math.min(take , nonTake );

    }
    
}
