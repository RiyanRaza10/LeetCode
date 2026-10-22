class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> all = new ArrayList<>();

        solve(all , n , 1);

        return all;
    }

    void solve(List<Integer> all , int n , int curr){
        // Greater than n , go back
        if(curr > n) return;

        all.add(curr);
      
        solve(all , n , curr*10);

        // In case , last digit of curr == 9 , do not add 1 , go back
        if((curr%10) != 9) solve(all , n , curr+1);
    }
}