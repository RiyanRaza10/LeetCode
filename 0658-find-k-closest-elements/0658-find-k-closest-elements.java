class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> kClosestElements = new ArrayList<>();
        
        int left = 0 , right = arr.length-1 , minIndX = arr.length , n = arr.length;

        // Estimating where element x should be placed in arr
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(arr[mid] >= x){
                minIndX = mid;
                right = mid - 1;
            }

            else left = mid + 1;
        }

        int i = minIndX , j = minIndX , cnt = 0;

        // Estimating range of indexes to be added in kClosestElements
        while(cnt < k){

            if(i >= 0 && j < n){

                if(Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) i--;
                
                else j++;
                
            }

            // minInd ke left me koi valid element nahi bacha
            // coz we reached -1 index
            else if(i < 0) j++;
            
            // minInd ke right me koi valid element nahi bacha
            // coz we reached n index
            else i--;

            cnt++;
        }

        // Since we are using post increment, so one index in extra in i & j
        // Therefore remove that extra index
        if(i < 0) i++;

        else if(j == n) j--;

        else{
            if(Math.abs(arr[i] - x) > Math.abs(arr[j] - x)) i++;
            else j--;
        }

        // Adding elements from the range of indexes : i && j
        for(int ind = i ; ind <= j ; ind++){
            kClosestElements.add(arr[ind]);
        }

        return kClosestElements;
        
    }
}