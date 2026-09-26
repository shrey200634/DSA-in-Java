package DynamicProgramming;

import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums, int sum) {

        int n = nums.length ;
        int [][] memo = new int[n][sum +1];

        for (int [] row : memo ){
            Arrays.fill(row , -1 );
        }
        int result = minCount(nums , n-1 , sum , memo );
        return result == Integer.MAX_VALUE ? -1 : result ;
        
    }

    private int minCount(int [] nums , int i , int sum , int [][] memo ){
        if (sum ==0 ){
            return 0 ;
        }
        if (i<0){
            return Integer.MAX_VALUE;
        }
        if (memo[i][sum] != -1){
            return memo[i][sum];
        }

        int ops =minCount(nums, i-1, sum , memo );
        int curr = nums[i];
        int opsCount =0;

        while (curr <= sum ){
            int res = minCount(nums , i-1 , sum -curr , memo);
            if (res != Integer.MAX_VALUE){
                ops = Math.min( ops , res + opsCount);
            }
            curr *= 2;
            opsCount ++ ;
        }

        opsCount = 0 ;
        curr = nums[i];
        while (curr >= 1 ){
            if (curr <= sum ){
            int res = minCount(nums , i-1 , sum-curr , memo );
            if ( res != Integer.MAX_VALUE){
                ops = Math.min(ops , res + opsCount );
            }
            }
            if (curr ==1 )break ;
            curr/= 2;
            opsCount ++ ;
        }
        return memo[i][sum] = ops ;
    }
}