//Find square root of a number in log n
public int mySqrt(int x) {

        int start = 1;
        int end = x;
        int ans = 0;
        while(start <= end ){
            int mid = start + (end - start)/2;
            long prod = (long)mid * mid;
            if(prod == x){
                return mid;
            }
            else if(prod > x){
                end = mid-1;
            }
            else{
                ans = mid;
                start = mid+1;
            }
        }
        return ans;
    }
