// Binary Search
public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                start =  mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }

//Order Agnostic Binary Search 
public int search(int[] nums, int target) {
        
        int n = nums.length;
        boolean isAsc = true;
        if(nums[0]>nums[n-1]){
          isAsc = false;
        }
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            }
              if(Asc){
                if(nums[mid] < target){
                start =  mid+1;
            }
            else{
                end = mid-1;
            }
              }
          else{
            if(nums[mid] < target){
                end =  mid-1;
            }
            else{
                start = mid+1;
            }
             
        }
        return -1;
    }


// Implement Lower bound 
int lowerBound(int[] arr, int target) {
        // code here
        int n = arr.length;
        int ans = n;
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = start + (end-start)/2;
             if(arr[mid] >= target){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }

//Implement Upper bound
int upperBound(int[] arr, int target) {
        // code here
        int n = arr.length;
        int ans = n;
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = start + (end-start)/2;
             if(arr[mid] >target){
                ans = mid;
                end = mid-1;
            }
            else{
                
                start = mid+1;
            }
        }
        return ans;

    }

  //Find floor/Ceil in a sorted array 
  public int findFloor(int[] arr, int target) {
        // code here
        int n = arr.length;
        int ans = -1;
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = start + (end-start)/2;
             if(arr[mid] <=target){
                ans = mid;
                start = mid+1;
            }
            else{
                
                end = mid-1;
            }
        }
        return ans;
    }

  public int findCeil(int[] arr, int target) {
        // code here
        // code here
        int n = arr.length;
        int ans = -1;
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = start + (end-start)/2;
             if(arr[mid] >=target){
                ans = mid;
                end = mid-1;
            }
            else{
                
                start = mid+1;
            }
        }
        return ans;
    }
//Search in Insert position 
public int searchInsert(int[] nums, int target) {
         int n = nums.length;
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                start =  mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return start;
    }

//Find the first or last occurrence of a given number in a sorted array
    public int findFirstOcc(int nums[] , int target){
         int n = nums.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                ans=  mid;
                end = mid-1;
            }
            else if(nums[mid] < target){
                start =  mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }

    public int findLastOcc(int nums[] , int target){
         int n = nums.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                ans=  mid;
                start = mid+1;
            }
            else if(nums[mid] < target){
                start =  mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = findFirstOcc(nums , target);
        int last = findLastOcc(nums , target);
        if(first == -1)return new int[]{-1,-1};
        return new int[]{first , last};
    }

//Count occurrences of a number in a sorted array with duplicates
int countFreq(int[] arr, int target) {
        // code here
        
        int first = findFirstOcc(arr , target);
        int last = findLastOcc(arr , target);
        if(first == -1)return 0;
        return last-first+1;
        
    }

//Search in Rotated Sorted Array I
public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        while(start <=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[start]<=nums[mid]){
                if(nums[start]<=target && nums[mid]>target){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if(nums[mid]<target && nums[end]>=target){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return -1;

    }

//Search in Rotated Sorted Array II
public boolean search(int[] nums, int target) {
         int n = nums.length;
        int start = 0;
        int end = n-1;
        while(start <=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                start++;
                end--;
            }
            else if (nums[start]<=nums[mid]){
                if(nums[start]<=target && nums[mid]>target){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if(nums[mid]<target && nums[end]>=target){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return false;

    }

//Find Minimum in Rotated Sorted Array
 public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0;
        int ans = Integer.MAX_VALUE;
        int end = n-1;
        if(nums[0]<=nums[end]){
            return nums[0];
        }
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[start]<=nums[mid]){
                ans = Math.min(ans , nums[start]);
                start = mid+1;
            }
            else{
                 ans = Math.min(ans , nums[mid]);
                end = mid-1;
            }
        }
        return ans;
    }

//Find out how many times the array has been rotated
 public int findMinIdx(int[] nums) {
        int n = nums.length;
        int start = 0;
        int ans = Integer.MAX_VALUE;
        int end = n-1;
        if(nums[0]<=nums[end]){
            return 0;
        }
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[start]<=nums[mid]){
                ans = start;
                start = mid+1;
            }
            else{
                 ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }

//Single element in a Sorted Array
public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];
        int start = 1;
        int end = n-2;
        if(nums[0] != nums[1])return nums[0];
        if(nums[n-1] != nums[n-2])return nums[n-1];
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }
            if(mid % 2 != 0){
                if(nums[mid] == nums[mid-1]){ // left part move to right part
                   start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            else{
                if(nums[mid] == nums[mid-1]){ // right part move to left part
                   end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }

        return -1;
    }

//Find peak element
 public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1)return 0;
        if(nums[0]>nums[1])return 0;
        if(nums[n-1]>nums[n-2])return n-1;
        int start = 1;
        int end = n-2;
        while(start <= end ){
            int mid = start + (end - start)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(nums[mid-1]<nums[mid]){
                //sorted part
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
