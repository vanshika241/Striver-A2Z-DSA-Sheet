class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n+1];
        if(arr[0] == 0)return -1;
        
        dp[0] = 0;
        for(int i=1;i<n;i++)dp[i] =Integer.MAX_VALUE; 
        for(int i=1;i<n;i++){
                for(int j=0;j<i;j++){
                    if(j+arr[j]>=i && dp[j] != Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i] , dp[j]+1);
                    }
                }
            }
        
        return dp[n-1] != Integer.MAX_VALUE ? dp[n-1]:-1 ;
        
                 
    }
}
