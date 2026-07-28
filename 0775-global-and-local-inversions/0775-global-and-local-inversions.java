class Solution {

    public boolean isIdealPermutation(int[] nums) {
        int local = 0 ;

        // Local inversions
        for(int i=0 ; i<nums.length-1 ; i++){
            if(nums[i] > nums[i+1]) local++;
        }

        // Global inversions
        int global = 0;
        global = mergeSort(nums , 0 , nums.length-1);

        System.out.println(global + " " + local);

        return local == global;
    }

    int mergeSort(int[] nums , int low , int high){
        
        // To count global inversions in this current array
        int cnt = 0;

        // Base Case
        if(low >= high) return cnt;

        int mid = (low + high)/2;

        // Global pair cnt
        cnt += mergeSort(nums , low , mid);

        // Global pair cnt
        cnt += mergeSort(nums , mid+1 , high);

        // Global pair cnt
        cnt += merge(nums , low , mid , high);

        // Total global pairs
        return cnt;
    }

    int merge(int[] nums , int low , int mid , int high){
        int[] temp = new int[high - low + 1];

        int left = low , right = mid+1 , ind = 0 , cnt  = 0;

        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp[ind++] = nums[left];
                left++;
            }

            else{
                temp[ind++] = nums[right];
                cnt += (mid - left + 1);       // Total global pairs till index(left) of (low to mid) array
                right++;
            }
        }

        while(left <= mid){
            temp[ind++] = nums[left];
            left++;
        }

        while(right <= high){
            temp[ind++] = nums[right];
            right++;
        }

        ind = 0;

        for(int i = low ; i <= high ; i++){
            nums[i] = temp[ind++];
        }

        // Return total global pairs in current array
        return cnt;

    }
}

// class Solution {

//     // cnt is declared globally
//     int cnt = 0;

//     public boolean isIdealPermutation(int[] nums) {
//         int local = 0;

//         for(int i=0 ; i<nums.length-1 ; i++){
//             if(nums[i] > nums[i+1]) local++;
//         }

//         mergeSort(nums , 0 , nums.length-1);

//         System.out.println(cnt + " " + local);

//         return local == cnt;
//     }

//     void mergeSort(int[] nums , int low , int high){

//         if(low >= high) return ;

//         int mid = (low + high)/2;

//         mergeSort(nums , low , mid);

//         mergeSort(nums , mid+1 , high);

//         merge(nums , low , mid , high);
//     }

//     void merge(int[] nums , int low , int mid , int high){

//         int[] temp = new int[high - low + 1];

//         int left = low , right = mid+1 , ind = 0;

//         while(left <= mid && right <= high){
//             if(nums[left] <= nums[right]){
//                 temp[ind++] = nums[left];
//                 left++;
//             }

//             else{
//                 temp[ind++] = nums[right];
//                 cnt += (mid - left + 1);        // Count pairs
//                 right++;
//             }
//         }

//         while(left <= mid){
//             temp[ind++] = nums[left];
//             left++;
//         }

//         while(right <= high){
//             temp[ind++] = nums[right];
//             right++;
//         }

//         ind = 0;

//         for(int i = low ; i <= high ; i++){
//             nums[i++] = temp[ind++];
//         }
//     }
// }