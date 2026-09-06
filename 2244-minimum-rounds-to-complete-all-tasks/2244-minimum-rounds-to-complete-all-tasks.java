class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer , Integer> map = new HashMap<>();
        
        for(int diff : tasks){
            map.put(diff , map.getOrDefault(diff , 0) + 1);
        }

        int rounds = 0;

        for(int difficulty : map.keySet()){
            
            // Have to choose at least 2
            if(map.get(difficulty) == 1) return -1;

            rounds += (int)Math.ceil( (double)(map.get(difficulty)) / 3 );
        }

        return rounds;
        
    }
}