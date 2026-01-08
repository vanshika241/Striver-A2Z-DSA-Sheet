class Solution {
    
    // public int rec(int W, int val[], int wt[] , int i , int n){
    //     if(i>=n)return 0;
    //     int skip = rec(W , val , wt , i+1 , n);
    //     int take = 0;
    //     if(wt[i] <=W){
    //         take = val[i] + rec(W-wt[i] , val , wt , i+1 , n);
    //     }
    //     return Math.max(take , skip);
        
    // }
    
    public int memo(int W, int val[], int wt[] , int i , int n , int dp[][]){
        if(i>=n)return 0;
        if(dp[i][W] != -1)return dp[i][W];
        int skip = memo(W , val , wt , i+1 , n , dp);
        int take = 0;
        if(wt[i] <=W){
            take = val[i] + memo(W-wt[i] , val , wt , i+1 , n , dp);
        }
        return dp[i][W] = Math.max(take , skip);
        
    }
    public int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;
        
        //return rec(W , val , wt , 0 , n);
        
        int dp[][] = new int[n+1][W+1];
        // for(int i=0;i<n;i++)Arrays.fill(dp[i] , -1);
        // return memo(W , val , wt , 0 , n , dp);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                int skip = dp[i-1][j];
                int take = 0;
                if(wt[i-1]<=j){
                    take = val[i-1]+  dp[i-1][j-wt[i-1]];
                }
                dp[i][j] = Math.max(skip , take);
            }
        }
        return dp[n][W];
        
    }
}
