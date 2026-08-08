class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0 , left = 0 , right = k , cnt = 0;

        // sum of first window
        for(int i=0 ; i<k ; i++){
            sum += arr[i];
        }

        if(sum / k >= threshold) cnt++;

        while(right < arr.length){
            
            sum += arr[right];
            sum -= arr[left];

            if(sum / k >= threshold) cnt++;

            right++;
            left++;
        }

        return cnt;
    }
}