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
}
