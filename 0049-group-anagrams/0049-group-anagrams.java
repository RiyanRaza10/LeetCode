class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Key Idea -> Sort every string in []strs 
        //             and make groups of same sorted strings in a hashmap
        // Return the values as they are grouped anagrams;
        
        HashMap<String , List<String>> map = new HashMap<>();

        for(String s : strs){

            // Sorting the string s bcz every sorted string is unique
            char []arr = s.toCharArray();
            Arrays.sort(arr);

            String sorted = new String(arr);

            // Create a key of sorted string
            if(!map.containsKey(sorted)) map.put(sorted , new ArrayList<String>() );
            
            // Put respective equal sorted strings in a group(ArrayList) 
            map.get(sorted).add(s);
        }

        // Return values in an ArrayList 
        return new ArrayList<>(map.values());
    }
}