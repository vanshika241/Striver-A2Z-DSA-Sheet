
//Count Frequency 
public static int[] findFrequency(String S) {
		// Write your code here.
		int n = S.length();
		HashMap<Character ,Integer> mp = new HashMap<>();
		for(int i=0;i<n;i++){
			mp.put(S.charAt(i) , mp.getOrDefault(S.charAt(i),0)+1);
		}
		int arr[] = new int[26];
		for(int i=0;i<26;i++){
			char ch = (char)('a'+i);
			if(mp.containsKey(ch)){
				arr[i] = mp.get(ch);
			}
			else{
				arr[i] = 0;
			}
		}
		return arr;
	}

//Highest / Lowest Frequency Elements
 public static int[] getFrequencies(int []v) {
        // Write Your Code Here
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<v.length;i++){
            mp.put(v[i] , mp.getOrDefault(v[i] , 0)+1);
        }
        int maxF = Integer.MIN_VALUE;
        int minF = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> e : mp.entrySet()){
             if(e.getValue()>maxF){
                maxF = e.getValue();
                maxi = e.getKey();
             }
             if(e.getValue()== maxF && e.getKey()<maxi){
                 maxi = e.getKey();
             }
             if(e.getValue()<minF){
                minF = e.getValue();
                mini = e.getKey();
             }
             if(e.getValue()== minF && e.getKey()<mini){
                 mini = e.getKey();
             }

        }
        return new int[]{maxi , mini};
    }

