class Solution {
    public boolean check(String wordA , String wordB){
        int n = wordA.length();
        int m = wordB.length();
        if(n+1 != m){
            return false;
        }
        int i=0; // a 
        int j =0; // b;
        while(i<n && j < m){
            if(wordA.charAt(i) == wordB.charAt(j)){
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return i == n;
    }
    public int longestStringChain(String words[]) {
        //LIS
        int n = words.length;
        int t[] = new int[n];
        Arrays.sort(words , (a,b)-> a.length()-b.length());
        Arrays.fill(t , 1);
        int maxi = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(check(words[j] , words[i])){
                    t[i] = Math.max(t[i], t[j]+1);
                    maxi = Math.max(maxi , t[i]);
                }
            }
        }
        return maxi;
        
    }
}
