class Solution {
    static boolean checkPal(String s , int i , int j ){
        if(i>j){
            return true;
        }
        if(s.charAt(i) == s.charAt(j)){
            return  checkPal(s , i+1 , j-1 );
        }
        else{
            return false;
        }
    }
    static String longestPalindrome(String s) {

        int n = s.length();
        int sp = -1;
        int maxlen = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(checkPal(s , i , j )){
                    if(j-i+1 > maxlen){
                        sp = i;
                        maxlen = j-i+1;
                    }
                }
            }
        }
        return s.substring(sp , sp+maxlen);
    }
}
