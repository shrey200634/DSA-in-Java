package DynamicProgramming;

import java.util.Arrays;

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int [][] dp = new int [n][m];
        

        for (int [] row : dp){
            Arrays.fill(row , -1);
        }        
        return find(n-1 , m-1 , word1 , word2 , dp);
    }

    private int find ( int i , int j , String s1 , String s2 , int [][] dp){

        if ( i<0) return j+1 ;
        if (j<0) return i+1 ;

        if ( dp[i][j] != -1){
            return dp[i][j];
        }

        if ( s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = 0+ find(i-1,j-1,s1,s2,dp);
        } else {

            dp[i][j] = 1 + Math.min(find(i-1,j,s1,s2,dp) , Math.min(find(i,j-1,s1,s2,dp) , find(i-1,j-1,s1,s2,dp))
            );

        }
        return dp[i][j];

    }
}
