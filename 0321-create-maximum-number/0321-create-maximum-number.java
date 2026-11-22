class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length , m = nums2.length;
        int[] res = new int[k];

        int low = (m >= k) ? 0 : k-m; // minElements to pick from nums1
        int high = Math.min(k , n); // maxElements to pick from nums2

        for(int i=low ; i<=high ; i++){
            int[] arr1 = new int[i];
            int[] arr2 = new int[k-i];

            construct(nums1 , arr1 , i);  // Choose i candidates from nums1
            construct(nums2 , arr2 , k-i); // Choose k-i candidates from nums2

            int[] merged = new int[k]; 
            merger(merged , arr1 , arr2); // Merge both arrays

            cmpLexicography(res , merged); // If merged is larger , update res   
        } 

        return res;
    }

    void construct(int[] nums , int[] temp , int totalElemToPick){
        Deque<Integer> dq = new ArrayDeque<>(); // Maintain a monotonic dq (decreasing)
        int n = nums.length;

        for(int i=0 ; i<n ; i++){
            // Imp step
            while(!dq.isEmpty() && dq.peekLast() < nums[i] && (n-i + dq.size()) > totalElemToPick) dq.pollLast();
            dq.offerLast(nums[i]);
        }

        // Since dq is monotonic decreasing , remove extra smaller elements from last
        while(dq.size() > totalElemToPick) dq.pollLast();

        for(int i=0 ; i<totalElemToPick ; i++) temp[i] = dq.pollFirst();
        
    }

    void merger(int[] merged , int[] arr1 , int[] arr2){
        int n1 = arr1.length , n2 = arr2.length;
        int i=0 , j=0 , mainIdx = 0;

        while(i < n1 && j < n2){
            if(arr1[i] > arr2[j]) merged[mainIdx++] = arr1[i++];
            else if(arr1[i] < arr2[j]) merged[mainIdx++] = arr2[j++];
            
            // If both are same , find kisme bada element milega aage
            else{
                if(cmp(arr1 , i , arr2 , j) == 1) merged[mainIdx++] = arr1[i++];
                else merged[mainIdx++] = arr2[j++];
            }
        }

        while(i < n1) merged[mainIdx++] = arr1[i++];
        while(j < n2) merged[mainIdx++] = arr2[j++];
    }

    int cmp(int[] arr1 , int i , int[] arr2 , int j){
        // Jab take same h aage badho
        while(i < arr1.length && j < arr2.length && arr1[i] == arr2[j]){
            i++;
            j++;
        }

        // Reached end of arr1
        // If arr2 ka bhi end ajaye , choose any of them
        // Else choose arr2 
        if(i == arr1.length){
            if(j == arr2.length) return 1;
            else return 2;
        }
        
        // Reached end of arr2
        // If arr1 ka bhi end ajaye , choose any of them
        // Else choose arr1 
        if(j == arr2.length){
            if(i == arr1.length) return 2;
            else return 1;
        }

        // Return jiska bhi elem bada wala ho 
        return arr1[i] > arr2[j] ? 1 : 2;
    }

    void cmpLexicography(int[] res , int[] merged){
        for(int i=0 ; i<res.length ; i++){
            if(res[i] > merged[i]) return;
            else if(merged[i] > res[i]) break;
        }

        for(int i=0 ; i<res.length ; i++) res[i] = merged[i];
    }
}