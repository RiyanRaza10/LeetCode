class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        
        // Already found
        if(buckets == 1) return 0;
        
        int rounds = 0;

        // Calculating total rounds
        while(minutesToTest >= minutesToDie){
            rounds++;
            minutesToTest -= minutesToDie;
        }

        int factor = rounds + 1 , pigs = 1 , currBucket = 1 + rounds , prev = rounds ;

        if(buckets <= currBucket) return pigs;

        // Jaise hi currBucket , buckets ko exceed kregi , turant return pigs
        while(currBucket <= 1000){
            
            if(currBucket >= buckets) return pigs;

            currBucket = currBucket + (prev)*factor;

            prev = prev * factor;

            pigs++;
        }

        return pigs;

    }
}