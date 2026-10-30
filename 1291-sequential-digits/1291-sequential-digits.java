class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Set<Integer> ans = new HashSet<>();

        solve(ans , low , high , (long)0);

        List<Integer> list = new ArrayList<>(ans);

        Collections.sort(list);

        return list;
    }

    void solve(Set<Integer> ans , int low , int high , long curr){

        if(curr > high) return;

        if(curr >= low && curr <= high) ans.add((int)curr);

        // Initialise with a digit
        if(curr == 0) 
        for(int i=1 ; i<9 ; i++){
            solve(ans , low , high , i);
        }
        
        int prev = (int)curr%10;
        // Do not generate when prev digit was 9
        if(prev != 9) solve(ans , low , high , curr*10 + prev+1);
    }
}