package DynamicProgramming;

public class TargetSumWays {
    public static int findWays(int num[], int tar) {
        int n = num.length;
        // dp[j] will store the number of subsets with sum equal to j
        int[] dp = new int[tar + 1];
        
        // Base case: There is 1 way to make sum 0 (by choosing an empty subset)
        dp[0] = 1;
        
        // Initialize for the first element if it does not exceed target
        if (num[0] <= tar) {
            dp[num[0]] = 1;
        }
        
        // Fill the DP table
        for (int i = 1; i < n; i++) {
            // Traverse backwards to avoid overwriting values needed for the current row
            for (int j = tar; j >= num[i]; j--) {
                dp[j] = dp[j] + dp[j - num[i]];
            }
        }
        
        return dp[tar];
    }
}