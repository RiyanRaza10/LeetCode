class Solution {
    public String findDifferentBinaryString(String[] nums) {
        List<String> ans = new ArrayList<>();
        
        HashMap<String , Integer> map = new HashMap<>();

        for(String s : nums) map.put(s , 0);

        generate(ans , map , new StringBuilder() , nums[0].length());

        return ans.get(0);
    }

    void generate(List<String> ans , HashMap<String , Integer> map , StringBuilder curr , int size){
        if(ans.size() > 0) return;

        if(curr.length() == size){
            if(!map.containsKey(curr.toString())) ans.add(curr.toString());

            return;
        }
        
        // Pick "0"
        curr.append("0");
        generate(ans , map , curr , size);

        // Backtrack / not pick "0"
        curr.deleteCharAt(curr.length()-1);

        // Pick "1"
        curr.append("1");
        generate(ans , map , curr , size);

        // Backtrack / not pick "1"
        curr.deleteCharAt(curr.length()-1);
    }
}