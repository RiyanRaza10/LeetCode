class Solution {
    
    public int minOperations(int[] nums) {
        int n = 100004;

        // Sieve
        boolean[] isComposite = new boolean[n];

        isComposite[1] = true;
    
        for(int i=2 ; i<n ; i++){
            if(!isComposite[i]){
                int j = 2*i;

                while(j < n){
                    isComposite[j] = true;
                    j += i;
                }
            }
        }

        int op = 0;

        for(int i=0 ; i<nums.length ; i++){
            if((i % 2 == 0 && !isComposite[nums[i]]) || (i % 2 == 1 && isComposite[nums[i]])) continue;

            else if(i % 2 == 0 && isComposite[nums[i]]){
                while(isComposite[nums[i]]){
                    nums[i] += 1;
                    op++;
                }
            }

            else if(i % 2 == 1 && !isComposite[nums[i]]){
                while(!isComposite[nums[i]]){
                    nums[i] += 1;
                    op++;
                }
            }
        }

        return op;
    }
}