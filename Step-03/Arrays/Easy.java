
//Largest Element in the Array
static int largestElement(int[] arr, int n) {
        // Write your code here.
        int maxi = arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>maxi){
                 maxi = arr[i];
            }
        }
        return maxi;

}
//Second Largest  and Smallest Number
public static int[] getSecondOrderElements(int n, int []arr) {
        // Write your code here.
        int maxi = Integer.MIN_VALUE;
        int smaxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        int smini = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>maxi){
                smaxi = maxi;
                maxi = arr[i];
            }
            else if(arr[i]<maxi && arr[i]>smaxi){
                smaxi = arr[i];
            }
             if(arr[i]<mini){
                smini = mini;
                mini = arr[i];
            }
            else if(arr[i]>mini && arr[i]<smini){
                smini = arr[i];
            }


        }
        return new int[]{smaxi , smini};

}


//Check if the array is sorted
public static int isSorted(int n, int []arr) {
        // Write your code here.
        for(int i=1;i<n;i++){
            if(arr[i]<arr[i-1])return 0;
        }
        return 1;
        
}

//Remove duplicates from Sorted array
public static int removeDuplicates(int[] arr,int n) {
        int idx = 0;
        for(int i=1;i<n;i++){
            if(arr[i] != arr[idx]){
                arr[idx+1] = arr[i];
                idx++;
            }
        }
        return idx+1;
}

//
