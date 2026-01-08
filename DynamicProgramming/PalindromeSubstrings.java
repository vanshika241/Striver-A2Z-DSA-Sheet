class Solution {
    
    // public boolean checkPal(String s , int i , int j , Boolean dp[][]){
    //     if(i>j)return true;
    //     if(dp[i][j] != null)return dp[i][j] ;
    //     if(s.charAt(i) == s.charAt(j)){
    //         return dp[i][j]  = checkPal(s , i+1 , j-1, dp);
    //     }
    //     else{
    //         return dp[i][j]  = false;
    //     }
    // }
    public int countPS(String s) {
        int n = s.length();
        int cnt = 0;
        boolean dp[][] = new boolean[n][n];
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(checkPal(s , i , j , dp)){
        //             cnt++;
        //         }
        //     }
        // }
        
        for(int L =1 ;L<=n;L++){
            for(int i = 0 ;i+L-1<n;i++){
                int j = i+L-1;
                if(i == j){
                    dp[i][j] = true;
                }
                else if(i+1 == j){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else {
                     dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
                }
                
                if(dp[i][j] == true && L>=2)cnt++;
            }
        }
        
        return cnt;
    }
}
