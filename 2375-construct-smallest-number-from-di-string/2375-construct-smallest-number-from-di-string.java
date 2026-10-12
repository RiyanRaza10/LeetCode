class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder[] ans = new StringBuilder[1];

        ans[0] = new StringBuilder(); // Initialise

        boolean[] used = new boolean[10];

        solve(pattern, used, ans, new StringBuilder(), 0);

        return ans[0].toString();
    }

    void solve(String pattern, boolean[] used, StringBuilder[] ans, StringBuilder curr, int ind) {

        // Do not generate when first letter of curr is greater than first letter of ans
        if (ans[0].length() == pattern.length() + 1 && ans[0].charAt(0) < curr.charAt(0))
            return;

        // A valid combination formed
        if (ind == pattern.length()) {
            
            // First ans
            if (ans[0].length() == 0)
                ans[0] = new StringBuilder(curr.toString());

            else {
                int cmp = curr.toString().compareTo(ans[0].toString());

                // If curr is lexicographically smaller , update ans
                if (cmp < 0)
                    ans[0] = new StringBuilder(curr.toString());
            }

            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {

                if (curr.length() == 0) {
                    // Pick
                    curr.append(i);
                    used[i] = true;

                    solve(pattern, used, ans, curr, ind);

                    // Backtrack
                    used[i] = false;
                    curr.deleteCharAt(curr.length() - 1);
                }

                else {
                    char state = pattern.charAt(ind);
                    int prev = curr.charAt(curr.length() - 1) - '0';

                    // Increasing sequence
                    if (state == 'I') {

                        if (i > prev) {
                            // Pick
                            curr.append(i);
                            used[i] = true;

                            solve(pattern, used, ans, curr, ind + 1);

                            // Backtrack
                            used[i] = false;
                            curr.deleteCharAt(curr.length() - 1);
                        }
                    }

                    // Decreasing sequence
                    else if (state == 'D') {

                        if (i < prev) {
                            // Pick
                            curr.append(i);
                            used[i] = true;

                            solve(pattern, used, ans, curr, ind + 1);

                            // Backtrack
                            used[i] = false;
                            curr.deleteCharAt(curr.length() - 1);
                        }
                    }
                }
            }
        }

    }
}