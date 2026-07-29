// Method - 1 [By declaring cnt locally, inside method]
class Solution {
   
    public int reversePairs(int[] nums) {

        int cnt = mergeSort(nums , 0 , nums.length-1);

        return cnt;
    }

    int mergeSort(int[] nums , int low , int high){
        int cnt = 0;

        if(low >= high) return cnt;
        
        int mid = (low + high) / 2;

        cnt += mergeSort(nums , low , mid);

        cnt += mergeSort(nums , mid+1 , high);

        cnt += merge(nums , low , mid , high);

        return cnt;

    }

    int merge(int[] nums , int low , int mid , int high){

        int i = low , j = mid+1 , cnt = 0;

        // Counting reverse pairs while keeping first pointer(i) in first sorted array [from low to mid]
        // and second pointer(j) in second sorted array [from mid+1 to high]
        while(i <= mid && j <= high){
            if(nums[i] > (long)2*nums[j]){
                cnt += (mid - i + 1);
                j++;
            }
            else i++;
        }

        // Merging algo starts here
        int[] temp = new int[high - low + 1];

        int left = low , right = mid + 1 , ind = 0;

        while(left <= mid && right <= high){
            temp[ind++] = nums[left] < nums[right] ? nums[left++] : nums[right++];
        }

        while(left <= mid){
            temp[ind++] = nums[left++];
        }

        while(right <= high){
            temp[ind++] = nums[right++];
        }

        for(int k=low ; k<=high ; k++){
            nums[k] = temp[k - low];
        }

        // Total reverse pairs in current array
        return cnt;

    }
}



// Method - 2 [By declaring cnt globally on class level] 
// class Solution {
   
//     int cnt = 0;

//     public int reversePairs(int[] nums) {

//         mergeSort(nums , 0 , nums.length-1);

//         return cnt;
//     }

//     void mergeSort(int[] nums , int low , int high){
        
//         if(low >= high) return;
        
//         int mid = (low + high) / 2;

//         mergeSort(nums , low , mid);

//         mergeSort(nums , mid+1 , high);

//         merge(nums , low , mid , high);
//     }

//     void merge(int[] nums , int low , int mid , int high){
//         int i = low , j = mid+1;

//         while(i <= mid && j <= high){
//             if(nums[i] > (long)2*nums[j]){
//                 cnt += (mid - i + 1);
//                 j++;
//             }
//             else i++;
//         }

//         int[] temp = new int[high - low + 1];

//         int left = low , right = mid + 1 , ind = 0;

//         while(left <= mid && right <= high){
//             temp[ind++] = nums[left] < nums[right] ? nums[left++] : nums[right++];
//         }

//         while(left <= mid){
//             temp[ind++] = nums[left++];
//         }

//         while(right <= high){
//             temp[ind++] = nums[right++];
//         }

//         for(int k=low ; k<=high ; k++){
//             nums[k] = temp[k - low];
//         }
//     }
// }