class Solution {
    public int count(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];
        for(int i=1;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                
                int skip = dp[i-1][j];
                int take = 0;
                if(coins[i-1]<=j){
                   take =   dp[i][j-coins[i-1]];
                   
                }
                dp[i][j] = skip + take;
            }
        }
        return dp[n][sum];
    }
}
