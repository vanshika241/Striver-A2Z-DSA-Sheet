
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

//Rotate array
public static void reverse(ArrayList<Integer> arr , int i , int j){
        while(i<j){
            int temp = arr.get(i);
            arr.set(i , arr.get(j));
            arr.set(j , temp);
            i++;
            j--;
        }
    }
	public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        // Write your code here.
        int n = arr.size();
        k = k%n;
        if(k == 0)return arr;
        reverse(arr , 0 , k-1);
        reverse(arr, k , n-1);
        reverse(arr , 0 , n-1);
        return arr;

        }

// Move Zeroes to End
public static void pushZerosAtEnd(ArrayList<Integer> arr)
	{
		// Write your code here
		int n = arr.size();
		int j=-1;
		for(int i=0;i<n;i++){
			if(arr.get(i) == 0){
				j = i;
				break;
			}
		}
		if(j == -1)return;
		for(int i=j+1;i<n;i++){
			if(arr.get(i) != 0){
				int temp = arr.get(i);
            arr.set(i , arr.get(j));
            arr.set(j , temp);
			j++;
			}
		}
		return;
}

// Linear Search
public static int linearSearch(int n, int num, int []arr){
        // Write your code here.
        for(int i=0;i<n;i++){
            if(arr[i] == num)return i;
        }
        return -1;
}

//
