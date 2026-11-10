class Solution {
    // Key Idea : Find next greater permutation of n
    // If next greater permutation is smaller than n , next greater doesnt exist , return -1
    public int nextGreaterElement(int n) {
        int len = (n+"").length();

        int[] nums = new int[len];
        int ind = 0 , num = n;

        while(num > 0){
            nums[len - ind - 1] = num%10;
            num /= 10;
            ind++;
        }

        int[] prev = new int[len];
        for(int i=0 ; i<len ; i++) prev[i] = nums[i];

        nextPermutation(nums , len);

        boolean exists = false;

        // Check if nums is a greater permutation of prev
        for(int i=0 ; i<len ; i++){
            if(nums[i] > prev[i]){
                exists = true;
                break;
            }
            else if(nums[i] < prev[i]) break; // i.e nums is a smaller permutation
        }

        // nums is a smaller permutation
        if(!exists) return -1;

        long res = 0;

        for(int i=0 ; i<len ; i++){
            res = res*10 + nums[i];
        }
        
        // If value overflows return -1 
        return res > Integer.MAX_VALUE ? -1 : (int)res;
    }

    void nextPermutation(int[] nums , int n){
        int ind = -1;
        for(int i=n-2 ; i>=0 ; i--){
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
        }

        if(ind == -1) return;

        for(int i=n-1 ; i>ind ; i--){
            if(nums[i] > nums[ind]){
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;

                break;
            }
        }

        reverse(nums , ind+1 , n-1);
    }

    void reverse(int[] nums , int s , int e){
        while(s < e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;

            s++;
            e--;
        }
    }
}