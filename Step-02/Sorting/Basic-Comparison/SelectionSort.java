import java.util.* ;
import java.io.*; 
public class SelectionSort {
	public static int getMax(int arr[] , int start , int last){
		int maxi = start;
		for(int i=0;i<=last;i++){
			if(arr[i]>arr[maxi]){
				maxi = i;
			}
		}
		return maxi;
	}
	public static void selectionSort(int arr[], int n) {
		for(int i=0;i<n;i++){
			int last = n-1-i;
			int maxi = getMax(arr , 0 , last);
			if(arr[maxi] != arr[last]){
				int temp = arr[maxi];
				arr[maxi] = arr[last];
				arr[last] = temp;
			}
		}
		return ;

	}
}
