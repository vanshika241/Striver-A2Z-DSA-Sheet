class Solution {
    
    // public int findcnt(String s1 , String s2 , int i , int j , int n1 , int n2 ,  int dp[][]){
    //     if(i == n1 && j == n2){
    //         return 0;
    //     }
    //     if(i == n1 ){
    //         return n2-j;
    //     }
    //     if(j == n2){
    //         return n1-i;
    //     }
    //     if(dp[i][j] != -1)return dp[i][j];
    //     if(s1.charAt(i) == s2.charAt(j)){
    //         return dp[i][j] = findcnt(s1 , s2 , i+1 , j+1 , n1 , n2,dp); 
    //     }
    //     else {
    //         int insert = 1+ findcnt(s1 , s2 , i , j+1 , n1 , n2 , dp); 
    //         int update = 1+ findcnt(s1 , s2 , i+1 , j+1 , n1 , n2 , dp); 
    //         int delete = 1+  findcnt(s1 , s2 , i+1 , j , n1 , n2 ,dp); 
    //         return  dp[i][j] = Math.min(insert , Math.min(update , delete));
    //     }
    // }
    public int editDistance(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int dp[][] = new int[n1+1][n2+1];
        // for(int i=0;i<n1;i++){
        //     Arrays.fill(dp[i] , -1);
        // }
        // return findcnt(s1 , s2 , 0 , 0 , n1 , n2 , dp); 
        for(int i=0;i<=n1;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<=n2;j++){
            dp[0][j] = j;
        }
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int insert = 1 + dp[i][j-1];
                    int update = 1 + dp[i-1][j-1];
                    int delete = 1 + dp[i-1][j];
                    dp[i][j] = Math.min(insert , Math.min(update , delete));
                }
            }
        }
        return dp[n1][n2];
        
        
    }
}
