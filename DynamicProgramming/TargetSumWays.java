package DynamicProgramming;

import java.util.Arrays;

public class TargetSumWays {
    public static int findWays(int num[], int tar) {
        int n = num.length;
        int[] dp = new int[tar + 1];
        
        dp[0] = 1;
        
        if (num[0] <= tar) {
            dp[num[0]] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = tar; j >= num[i]; j--) {
                dp[j] = dp[j] + dp[j - num[i]];
            }
        }
        
        return dp[tar];
    }




    
    private static int solve(int idx, int target, int[] num, int[][] dp) {
        if (idx == 0) {
            if (target == 0 && num[0] == 0) return 2;
            
            if (target == 0 || num[0] == target) return 1;
            
            return 0; 
        }
        
        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }
            int notPick = solve(idx - 1, target, num, dp);
        
        int pick = 0;
        if (num[idx] <= target) {
            pick = solve(idx - 1, target - num[idx], num, dp);
        }
        
        return dp[idx][target] = pick + notPick;
    }

    public static int findWays2(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
                return solve(n - 1, tar, num, dp);
    }

    class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // Edge cases: if (target + sum) is odd or target exceeds total sum
        if ((sum + target) % 2 != 0 || Math.abs(target) > sum) {
            return 0;
        }
        
        int subsetSum = (sum + target) / 2;
        int n = nums.length;
        
        // dp[i][j] = number of subsets using first i elements that sum to j
        int[][] dp = new int[n + 1][subsetSum + 1];
        
        // Base case: There is 1 way to make sum 0 (by picking nothing)
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            // Note: Start j from 0 to correctly handle elements where nums[i-1] == 0
            for (int j = 0; j <= subsetSum; j++) {
                // 1. Not Pick option (exclude current element)
                int notPick = dp[i - 1][j];
                
                // 2. Pick option (include element if it doesn't exceed target sum j)
                int pick = 0;
                if (nums[i - 1] <= j) {
                    pick = dp[i - 1][j - nums[i - 1]];
                }
                
                // Total ways is the sum of both decisions
                dp[i][j] = pick + notPick;
            }
        }
        
        return dp[n][subsetSum];
    }
}
}
