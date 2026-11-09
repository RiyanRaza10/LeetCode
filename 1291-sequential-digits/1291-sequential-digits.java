class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        for(int i=1 ; i<9 ; i++){
            solve(ans , low , high , (long)i);
        }
        
        Collections.sort(ans);

        return ans;
    }

    void solve(List<Integer> ans , int low , int high , long curr){

        if(curr > high) return;

        if(curr >= low && curr <= high) ans.add((int)curr);
        
        int prev = (int)curr%10;
        // Do not generate when prev digit was 9
        if(prev != 9) solve(ans , low , high , curr*10 + prev+1);
    }
}