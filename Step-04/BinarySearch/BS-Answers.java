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

//Find the Nth root of a number using binary search
public int nthRoot(int n, int m) {
        if(n == 0 || m == 0)return 0;
        int start = 1;
        int end = m;
        while(start<=end){
            int mid = start + (end-start)/2;
            long prod = (long)Math.pow(mid , n);
            if(prod == m ){
                return mid;
            }
            else if(prod>m){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }

// Koko eating bananas
  public boolean isValid(int[] piles, long mid , int h){
        long totalHours = 0;
        for(int num:piles){
            totalHours += (int)Math.ceil((double)num/mid);
        }
        return totalHours<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        long start = 1;
        long end = 1;
        long ans = start;
        for(int num : piles){
            end = Math.max(num , end);
        }
        while(start<=end){
            long mid = start+(end-start)/2;
            if(isValid(piles , mid , h)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return (int)ans;
    }

//
