class Solution {
    public int longestMountain(int[] arr) {
        int maxLen = 0 , i = 0;

        while(i < arr.length-1){
            boolean leftFound = false , rightFound = false;

            int start = -1 , end = -1;

            // Find if peak towards mountain exists
            while(i < arr.length-1 && arr[i] < arr[i+1]){
                if(leftFound == false){
                    leftFound = true;
                    start = i;
                }
                i++;
            }

            // Find if downward slope from mountain exists
            if(leftFound){
                while(i < arr.length-1 && arr[i] > arr[i+1]){
                    if(rightFound == false){
                        rightFound = true;
                    }
                    end = i+1;
                    i++;
                }
            }
            
            else i++;

            if(leftFound && rightFound){
                maxLen = Math.max(maxLen , end - start + 1);
            }

            }

            return maxLen;
        
    }
}