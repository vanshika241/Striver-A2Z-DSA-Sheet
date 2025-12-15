
//Next Permutation
	public static void reverse(ArrayList<Integer> arr , int i , int j){
        while(i<j){
            int temp = arr.get(i);
            arr.set(i , arr.get(j));
            arr.set(j , temp);
            i++;
            j--;
        }
    }

	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
	{
		// Write your code here
		
		int n = permutation.size();
		int pivot = -1;
		for(int i=n-2;i>=0;i--){
			if(permutation.get(i)<permutation.get(i+1)){
				pivot = i;
				break;
			}
		}

		if(pivot == -1){
			reverse(permutation , 0 , n-1);
			return permutation;
		}

		for(int i=n-1;i>=pivot;i--){
			if(permutation.get(i)>permutation.get(pivot)){
				int temp = permutation.get(i);
				permutation.set(i , permutation.get(pivot));
				permutation.set(pivot , temp);
				break;
			}
		}

		reverse(permutation , pivot+1 , n-1);
        return permutation;
	}
