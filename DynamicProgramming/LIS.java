class Solution {
    
    //Recursion
    // public static int findLIS(int arr[] , int currIdx , int prevIdx , int n ){
    //     if(currIdx == n){
    //         return 0;
    //     }
    //     int skip = findLIS(arr , currIdx+1 , prevIdx , n);
    //     int take = 0;
    //     if(prevIdx == -1 || arr[currIdx]>arr[prevIdx]){
    //         take = 1+ findLIS(arr , currIdx+1 , currIdx , n);
    //     }
    //     return Math.max(skip , take);
        
    // }
    
    //Memo 
    public static int findLIS(int arr[] , int currIdx , int prevIdx , int n , int dp[][] ){
        if(currIdx == n){
            return 0;
        }
        if(dp[currIdx][prevIdx+1] != -1)return dp[currIdx][prevIdx+1];
        int skip = findLIS(arr , currIdx+1 , prevIdx , n , dp);
        int take = 0;
        if( prevIdx == -1 || arr[currIdx]>arr[prevIdx]){
            take = 1+ findLIS(arr , currIdx+1 , currIdx , n , dp);
        }
        return dp[currIdx][prevIdx+1] =  Math.max(skip , take);
        
    }
    static int lis(int arr[]) {
        int n = arr.length;
        // int dp[][] = new int[n][n+1];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i] , -1);
        // }
        
        // return findLIS(arr , 0 , -1 , n , dp);
        
        int t[] = new int[n];
        Arrays.fill(t , 1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i]){
                    t[i] = Math.max(t[i] , t[j]+1);
                }
            }
        }
        int maxi = 0;
        for(int i=0;i<n;i++){
            maxi = Math.max(maxi , t[i]);
        }
        return maxi;
    }
}
