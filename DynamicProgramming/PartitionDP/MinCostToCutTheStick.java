package DynamicProgramming.PartitionDP;

import java.util.Arrays;

public class MinCostToCutTheStick {





    public int minCost(int n, int[] cuts) {
        int m = cuts.length ;
        int []c = new int [m+2];

        System.arraycopy(cuts, 0, c, 1, m);
        c[0] = 0;
        c[m + 1] = n;

        Arrays.sort(c);

        int len = c.length ;


        int [][] dp = new int [len][len];
        for ( int [] row : dp ){
            Arrays.fill( row , -1 );

        }
        return solve (0 , len -1 , c, dp);
    }

    private int solve ( int i , int j , int [] c , int [][] dp ){
        if ( i+1 >= j ) return 0 ;

        if ( dp[i][j] != -1 ){
            return dp[i][j];
        }

        int minimum = Integer.MAX_VALUE;

        for ( int k =i+1 ; k< j; k++){
          int currentCost = (c[j] - c[i]) + solve(i, k, c, dp) + solve(k, j, c, dp);
            minimum = Math.min(minimum , currentCost );

        }
        return dp[i][j] = minimum ;


    }








  
}
    

