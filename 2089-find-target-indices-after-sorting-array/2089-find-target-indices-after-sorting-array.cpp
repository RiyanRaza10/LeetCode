class Solution {
public:
    vector<int> targetIndices(vector<int>& nums, int target) {
        vector<int> ans;

        int ind = 0, freq = 0;

        for(int i=0 ; i<nums.size() ; i++){
            if(nums[i] == target) freq++;
            else if(nums[i] < target) ind++;
        }

        for(int i=ind ; i<ind+freq ; i++){
            ans.push_back(i);
        }

        return ans;
    }
};