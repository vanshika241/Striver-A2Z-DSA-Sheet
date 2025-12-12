public class InsertionSort {

	public static void insertionSort(int n , int[] arr) {
		// Write your code here.
		for(int i=1;i<n;i++){
			int j = i;
			while(j>0 && arr[j]<arr[j-1]){
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				j--;
			}
		}
	}
}
