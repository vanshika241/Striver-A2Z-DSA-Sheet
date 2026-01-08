
class Solution {
    static int minCostClimbingStairs(int[] cost) {
        // Write your code here
        int n = cost.length;
        int dp[] = new int[n];
         dp[0] = cost[0];
         dp[1] = cost[1];
         for(int i=2;i<n;i++){
             int step1 = cost[i]+dp[i-1];
             int step2 = cost[i]+dp[i-2];
             dp[i] = Math.min(step1 , step2);
         }
         return Math.min(dp[n-1],dp[n-2]);
    }
};
