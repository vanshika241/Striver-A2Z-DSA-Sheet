public class BubbleSort {
    public static void bubbleSort(int[] arr, int n) {
        //Your code goes here
        for(int i=0;i<n;i++){
            boolean check = false;
            for(int j=1;j<n-i;j++){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    check = true;
                }
            }
            if(check = false){
                return;
            }
        }
    }

}
