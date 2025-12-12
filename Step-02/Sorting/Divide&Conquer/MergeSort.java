import java.util.ArrayList;
public class MergeSort {

    public static void merge(int[] arr, int low, int mid ,  int high){
        ArrayList<Integer> ans = new ArrayList<>();
        int i = low;
        int j = mid+1;
        while(i<=mid && j<=high){
            if(arr[i] <=arr[j]){
                ans.add(arr[i]);
                i++;
            }
            else{
                ans.add(arr[j]);
                j++;
            }
        }
        while(i<=mid){
            ans.add(arr[i]);
                i++;
        }
        while(j<=high){
            ans.add(arr[j]);
                j++;
        }
        for(int id=low;id<=high;id++){
            arr[id] = ans.get(id-low);
        }
    }

    public static void mergeSort1(int arr[], int low , int high){
        if(low >= high){
            return;
        }
        int mid = low + (high-low)/2;
        mergeSort1(arr , low , mid);
        mergeSort1(arr , mid+1 , high);
        merge(arr , low , mid , high);
        return;
    }
    public static void mergeSort(int[] arr, int l, int r){
        // Write your code here
        int n = arr.length;
         mergeSort1(arr , 0 , n-1);
         return;

    }
}
