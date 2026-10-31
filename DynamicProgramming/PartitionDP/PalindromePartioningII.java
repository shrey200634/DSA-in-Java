package DynamicProgramming.PartitionDP;

import java.util.Arrays;

public class PalindromePartioningII {


    class Solution {
    public int minCut(String s) {
        int n = s.length();
        int [] dp = new int [n];
        Arrays.fill(dp , -1 );
        return solve( 0 , s , dp)-1;
        
    }

    private int solve (int i , String s , int [] dp ){
         int n = s.length();
        if ( i ==n ) {
            return 0 ;
        }
        if ( dp[i] != -1 ){
            return dp[i];
        }
        int minCost = Integer.MAX_VALUE;
        for ( int j =i ; j<n ; j++){
            if (ispalindrome(i ,j,s)){
                int cost = 1 + solve (j+1 , s , dp);
                minCost = Math.min(cost , minCost );
            }
        }
        return dp[i] = minCost ;

    }


    private boolean ispalindrome( int i , int j , String s ){
        while ( i< j ){
            if ( s.charAt(i) != s.charAt(j)){
                return false ;
            }
            i++ ;
            j-- ;
        }
        return true ;
    }
}
    
}
