class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();

        for(int i=1 ; i<9 ; i++){
            solve(res , low , high , (long)i);
        }

        Collections.sort(res);
        return res;
    }

    void solve(List<Integer> res , int low , int high , long curr){

        if(curr > high) return;

        if(curr >= low && curr <= high) res.add((int)curr);

        int prevDigit = (int)(curr) % 10;
        if(prevDigit != 9) solve(res , low , high , curr*10 + (prevDigit + 1));
    }
}