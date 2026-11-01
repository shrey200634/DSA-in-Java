package DynamicProgramming.PartitionDP;

import java.util.Arrays;

public class maxSumAfterPartitioning {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length ;
        int [] dp = new int [n+1];

        Arrays.fill(dp , -1 );
        return solve ( 0 , k , arr , dp);
        
    }

    private int solve ( int index , int k ,int [] nums , int []dp ){
        int n = nums.length ;

        if ( index ==n ){
            return 0 ;
        }

        if (dp[index] != -1 ){
            return dp[index];
        }

        int len =0 ;
        int maxi=0 ;
        int maxSum =0;


        for ( int j =index ; j< Math.min(n , index+k) ; j++){
            len++ ;
            maxi = Math.max(maxi , nums[j]);
            int sum = (len * maxi ) + solve ( j+1 , k , nums , dp );
             maxSum = Math.max(sum , maxSum);
        }
        return dp[index]= maxSum ;
    }
}
    

