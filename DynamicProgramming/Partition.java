package DynamicProgramming;
public class Partition {

    class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0 ;

        for (int num : nums ) sum += num ;
        if ( sum %2 != 0){
            return false ;
        }
        int target = sum /2;
        Integer [][] dp = new Integer [nums.length ][target+1];
        return solve (0,target , nums,dp);
    }
    private boolean solve ( int index , int target , int [] nums , Integer [][] dp){
        if ( target ==0 ){
            return true ;
        }
        if ( index ==nums.length ){
            return false ;
        }

       if ( dp[index][target] != null){
        return dp[index ][target] ==1 ;
       }
       boolean nonTake = solve ( index+1 , target , nums , dp );

       boolean take = false ;
       if ( nums[index] <= target ){
        take = solve ( index +1 , target - nums[index ] , nums , dp);
       }
      dp[index][target] = (take || nonTake) ? 1 : 0;

      return take || nonTake ;
    }
}
    
}
