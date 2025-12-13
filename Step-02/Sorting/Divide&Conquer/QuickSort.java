import java.util.* ;
import java.io.*; 
public class QuickSort {

    public static int findPivot(List<Integer> arr , int low , int high){
        int i=low;
        int j = high;
        int pivot = low;
        while(i<=j){
            while(i<=j && arr.get(i)<=arr.get(pivot)){
                i++;
            }
            while(i<=j && arr.get(j)>arr.get(pivot)){
                j--;
            }
            if(i<j){
                int temp = arr.get(i);
                arr.set(i , arr.get(j));
                arr.set(j , temp);
                i++;
                j--;
            }
        }

          int temp = arr.get(j);
                arr.set(j , arr.get(pivot));
                arr.set(pivot , temp);
                return j;

    }
    public static void quick(List<Integer> arr , int low , int high ){
        if(low>=high){
            return;
        }
        int pivot = findPivot(arr , low , high);
        quick(arr , low , pivot-1);
        quick(arr , pivot+1,high);
        return;
    }
    public static List<Integer> quickSort(List<Integer> arr){
        // Write your code here.
        int n = arr.size();
        quick(arr , 0 , n-1);
        return arr;

    }
}
