package DynamicProgramming.PartitionDP;

import java.util.Arrays;

public class MinCostToCutTheStickTabulation {


     public int minCost(int n, int[] cuts) {
         int [] c = new int [cuts.length +2  ];
        System.arraycopy( cuts, 0, c, 1, cuts.length );
        c [0] = 0;
        c[ cuts.length + 1] = n;
        Arrays.sort( c);

        int len = c.length ;
        int [][] dp = new int [len][len];

        for ( int i = len-1 ; i>= 0 ; i--){
            for ( int j = i+2 ; j< len ; j++){
                int minimum = Integer.MAX_VALUE;
           for ( int k = i+1 ; k<j ; k++){
                int currCost = (c[j]-c[i]) + dp [i][k] + dp[k][j];
                minimum = Math.min(currCost , minimum);
            }
              dp[i][j] = minimum ;
            }
        }
        return dp[0][len-1];

    }
    
}
