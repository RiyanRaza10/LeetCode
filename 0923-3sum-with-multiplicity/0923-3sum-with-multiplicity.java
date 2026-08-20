class Solution {
    public int threeSumMulti(int[] arr, int target) {
        HashMap<Integer , Integer> map = new HashMap<>();

        Set<List<Integer>> set = new HashSet<>();

        for(int val : arr) map.put(val , map.getOrDefault(val , 0) + 1);
        
        Arrays.sort(arr);

        long cnt = 0 , MOD = (long)(1e9 + 7);

        for(int i=0 ; i<arr.length-2 ; i++){

            int left = i+1 , right = arr.length-1 ;

            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];

                if(sum == target){

                    // To avoid used triplets
                    if(!set.contains(Arrays.asList(arr[i] , arr[left] , arr[right]))){
                        
                        // All elements equal
                        if(arr[i] == arr[left] && arr[left] == arr[right]) {

                            cnt += ((long)map.get(arr[i]) * (map.get(arr[left]) - 1) * (map.get(arr[right]) - 2) ) / 6 ;
                        }

                        // First two elements equal
                        else if(arr[i] == arr[left]){

                            cnt += ( (long)map.get(arr[i]) * (map.get(arr[i]) - 1) / 2 ) * map.get(arr[right]);
                        
                        }

                        // Last 2 elements equal
                        else if(arr[left] == arr[right]){
                            
                            cnt += ( (long)map.get(arr[i]) * ( (map.get(arr[left])-1) * map.get(arr[left]) ) / 2 ) ;

                        }

                        // All Different
                        else{
        
                            cnt += ( (long)map.get(arr[i]) * map.get(arr[left]) * map.get(arr[right]) );;

                        }

                        cnt %= MOD;

                        // Used tripet
                        set.add(Arrays.asList(arr[i] , arr[left] , arr[right]));

                    }
                    
                    left++;
                    right--;

                }

                else if(sum < target) left++;

                else right--;

            }
        }

        return (int)cnt;

    }
}