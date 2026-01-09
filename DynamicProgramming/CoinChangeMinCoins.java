class Solution {

    public int minCoins(int coins[], int sum) {
         int n = coins.length;
         int dp[][] = new int[n+1][sum+1];
         int INF = (int)1e9;
         for(int i=0;i<=n;i++){
             for(int j=0;j<=sum;j++){
                 dp[i][j] = INF;
             }
         }
         for(int i=0;i<=n;i++){
             dp[i][0] = 0;
         }
         for(int j=1;j<=sum;j++){
             if(coins[0]<= j){
                 if(j%coins[0] == 0){
                     dp[1][j] = j/coins[0];
                 }
                 
                 
             }
         }
         
         for(int i=2;i<=n;i++){
             for(int j=1;j<=sum;j++){
                 int skip = dp[i-1][j];
                 int take = INF;
                 if(coins[i-1] <=j){
                      take = 1 + dp[i][j-coins[i-1]];
                 }
                 dp[i][j] = Math.min(take , skip);
             }
         }
         
         return dp[n][sum] != INF?dp[n][sum] : -1;
         
    }
}
