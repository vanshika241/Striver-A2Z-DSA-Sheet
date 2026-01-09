class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
          int n = arr.length;
          boolean dp[][]= new boolean[n+1][sum+1];
          for(int i=0;i<=n;i++){
              dp[i][0] = true;
          }
          for(int i=1;i<=n;i++){
              for(int j=1;j<=sum;j++){
                  boolean skip = dp[i-1][j];
                  boolean take = false;
                  if(j-arr[i-1]>=0){
                      take = dp[i-1][j-arr[i-1]];
                  }
                  dp[i][j] = take || skip;
              }
              
          }
          return dp[n][sum];
    } 
    
}
