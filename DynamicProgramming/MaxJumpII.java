
package DynamicProgramming;

import  java.util.*;
class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length  ;
        Integer [] dp = new Integer [n];
        return solve(0, nums,dp);
    }
    private int solve ( int i , int [] nums , Integer [] dp){
        if (i>= nums.length -1 ){
            return 0 ;
        }
        if ( dp[i] != null){
            return dp[i];
        }

         int minJump = (int)1e9;
         int maxJump = Math.min(i+nums[i] , nums.length-1 );
         for ( int j = i+1 ; j<= maxJump ; j++){
            minJump = Math.min( minJump , 1+ solve(j , nums , dp));
         }
         dp[i] = minJump ;
         return dp[i];


    }
}