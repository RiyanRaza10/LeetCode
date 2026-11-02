class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] cost = new int[26];
        Arrays.fill(cost , -9999);

        for(int i=0 ; i<chars.length() ; i++) cost[chars.charAt(i) - 'a'] = vals[i];

        int[] nums = new int[s.length()];

        // Create an array containing cost for each character in s
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            nums[i] = cost[ch - 'a'] == -9999 ? ch - 'a' + 1 : cost[ch - 'a'];
        }

        int maxSum = 0 , currSum = 0;

        // Kadane's
        for(int i=0 ; i<nums.length ; i++){
            currSum += nums[i];

            if(currSum < 0) currSum = 0;

            maxSum = Math.max(maxSum , currSum);
        }

        return maxSum;
    }
}