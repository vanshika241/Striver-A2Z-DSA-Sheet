class Solution {
    // public static int findLCS(int idx1 , int idx2 , int n1 ,int n2 , String s1 ,String s2){
    //     if(idx1 == n1 || idx2 == n2)return 0;
    //     if(s1.charAt(idx1) == s2.charAt(idx2)){
    //         return 1 + findLCS(idx1+1 , idx2+1 , n1 , n2 , s1 , s2);
    //     }
    //     else{
    //         return Math.max(findLCS(idx1 , idx2+1 , n1 , n2 , s1 , s2) , findLCS(idx1+1 , idx2 , n1 , n2 , s1 , s2));
    //     }
    // }
    
    public static int findLCS(int idx1 , int idx2 , int n1 ,int n2 , String s1 ,String s2 , int dp[][]){
        if(idx1 == n1 || idx2 == n2)return 0;
        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return  dp[idx1][idx2] = 1 + findLCS(idx1+1 , idx2+1 , n1 , n2 , s1 , s2 , dp);
        }
        else{
            return  dp[idx1][idx2] = Math.max(findLCS(idx1 , idx2+1 , n1 , n2 , s1 , s2 , dp) , findLCS(idx1+1 , idx2 , n1 , n2 , s1 , s2 , dp));
        }
    }
    static int lcs(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        // int dp[][] = new int[n1][n2];
        // for(int i=0;i<n1;i++){
        //     Arrays.fill(dp[i] , -1);
        // }
        // return findLCS(0 , 0 , n1 , n2 , s1 , s2 , dp);
        
        int dp[][] = new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        
        return dp[n1][n2];
        
    }
}
