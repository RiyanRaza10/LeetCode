class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        solve(res , n , 1);
        return res;
    }

    void solve(List<Integer> res , int n , int curr){
        if(curr > n) return;

        res.add(curr);
        
        solve(res , n , curr*10);
        if((curr%10) != 9) solve(res , n , curr+1);
    }
}