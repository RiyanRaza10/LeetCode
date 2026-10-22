class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> all = new ArrayList<>();
        boolean[] used = new boolean[n+1];

        solve(all , used , n , 1);

        return all;
    }

    void solve(List<Integer> all , boolean[] used , int n , int curr){

        if(curr > n || used[curr]) return;

        all.add(curr);
        used[curr] = true;
      
        solve(all , used , n , curr*10);

        if((curr%10) != 9) solve(all , used , n , curr+1);
    }
}