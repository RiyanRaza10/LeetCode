class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        int lowerBound = (int)Math.pow(10 , n-1);
        int upperBound = (int)Math.pow(10 , n)-1;

        List<Integer> list = new ArrayList<>();

        solve(list , n , k , lowerBound , upperBound , 0 , 0);

        int[] numbers = new int[list.size()];
        
        for(int i=0 ; i<list.size() ; i++) numbers[i] = list.get(i);

        return numbers;
    }

    void solve(List<Integer> ans , int n ,int k , int low , int high , int curr , int size){

        // A number of valid size is formed
        if(size == n){
            ans.add(curr);

            return;
        }

        for(int i=0 ; i<=9 ; i++){
            // Avoid leading zero
            if(curr == 0 && i == 0) continue;

            // can pick any number as initial except 0
            if(curr == 0) solve(ans , n , k , low , high , i , 1);

            // Check if i can be used
            else if(Math.abs((curr % 10) - i) == k){
                solve(ans , n , k , low , high , curr*10+i , size+1);
            } 
        }
    }
}