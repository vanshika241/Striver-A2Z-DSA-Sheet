class Solution {
    // public int findLPS(String s , int i , int j){
    //     if(i >j)return 0;
    //     if(i == j){
    //         return 1;
    //     }
    //     if(s.charAt(i) == s.charAt(j)){
    //         return 2 + findLPS(s , i+1 , j-1);
    //     }
    //     else{
    //         return Math.max(findLPS(s , i , j-1) , findLPS(s , i+1 , j));
    //     }
    // }
    
    // public int findLPS(String s , int i , int j , int dp[][]){
    //     if(i >j)return 0;
    //     if(i == j){
    //         return 1;
    //     }
    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }
    //     if(s.charAt(i) == s.charAt(j)){
    //         return  dp[i][j] = 2 + findLPS(s , i+1 , j-1 , dp);
    //     }
    //     else{
    //         return dp[i][j] = Math.max(findLPS(s , i , j-1 , dp) , findLPS(s , i+1 , j , dp));
    //     }
    // }
    
    
    public int longestPalinSubseq(String s) {
       int n = s.length();
       if(n == 0)return 0;
    //   int dp[][] = new int[n][n];
    //   for(int i=0;i<n;i++)Arrays.fill(dp[i] , -1);
    //   return findLPS(s , 0 , n-1 , dp);
    
    int dp[][] = new int[n][n];
    for(int i=0;i<n;i++){
        dp[i][i] = 1;
    }
    for(int i=n-1;i>=0;i--){
        for(int j=i+1;j<n;j++){
            if(s.charAt(i) == s.charAt(j)){
                dp[i][j] = 2 + dp[i+1][j-1];
            }
            else{
                dp[i][j] = Math.max(dp[i+1][j] , dp[i][j-1]);
            }
        }
    }
    return dp[0][n-1];
    
    
    }
}
