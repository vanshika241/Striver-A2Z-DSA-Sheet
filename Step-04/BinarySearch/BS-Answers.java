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

//Minimum days to make M bouquets
 public boolean isValid(int[] bloomDay, int mid, int k , int m){
        int n = bloomDay.length;
        int temp = k;
        int cnt = 0;
        int i=0;
        while(i<n){
            if(bloomDay[i]<=mid){
              temp--;
              if(temp == 0){
                temp = k;
                cnt++;
              }
              i++;
              
            }
            else{
                temp = k;
                i++;
            }
        }
        return cnt >= m;

    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int start = 1;
        int end = 1;
        int ans = -1;
        int temp = m;
        for(int num:bloomDay){
            end = Math.max(end , num);
        }
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isValid(bloomDay , mid , k,m)){
               ans= mid;
               end = mid-1;
               temp--;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }

//Find the Smallest Divisor Given a Threshold
public boolean isValid(int[] nums, int mid , int threshold){
        int sum =0;
        for(int num:nums){
            sum += Math.ceil((double)num/mid);
        }
        return sum <= threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int start = 1;
        int end = 1;
        int ans = 1;
        for(int num:nums){
            end = Math.max(end , num);
        }
        while(start <=end){
            int mid = start + (end-start)/2;
            if(isValid(nums , mid , threshold)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }

// Capacity To Ship Packages Within D Days
    public boolean isValid(int[] weights, int days , int mid){
        int cnt = 1;
        int sum = 0;
        for(int num:weights){
            sum += num;
            if(sum>mid){
                cnt++;
                sum = num;
            }
        }
        return cnt <=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int start = 1;
        int end = 0;
        int ans = 1;
        for(int num:weights){
            start = Math.max(start , num);
            end += num;
        }
        while(start <= end){
            int mid = start + (end-start)/2;
            if(isValid(weights , days , mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }

//Book Allocation Problem
 public boolean isValid(int[] nums, int k , int mid){
        int sum = 0;
        int cnt = 1;
        for(int num : nums){
            sum += num;
            if(sum >mid){
                sum = num;
                cnt++;
            }
        }
        return cnt<=k;
    }
    public int findPages(int[] nums, int k) {
        // code here
          int n = nums.length;
          if(n<k)return -1;
        int start = 0;
        int end = 0;
        
        for(int num:nums){
            start = Math.max(num , start);
            end += num;
        }
        int ans = -1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(isValid(nums , k , mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
        
    }

//Split Array Largest Sum
public boolean isValid(int[] nums, int k , int mid){
        int sum = 0;
        int cnt = 1;
        for(int num : nums){
            sum += num;
            if(sum >mid){
                sum = num;
                cnt++;
            }
        }
        return cnt<=k;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int end = 0;
        
        for(int num:nums){
            start = Math.max(num , start);
            end += num;
        }
        int ans = end;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(isValid(nums , k , mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
