class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<List<Integer> , Integer> map = new HashMap<>();
        
        // For checking seats only in those rows which already have some booked seats
        // Otherwise 2 groups can be formed in a single empty row
        Set<Integer> crowdedRows = new HashSet<>(); 
        
        int groups = 0;

        for(int[] resSeats : reservedSeats){
            map.put(Arrays.asList(resSeats[0] , resSeats[1]) , 0 );

            // Crowded rows
            crowdedRows.add(resSeats[0]);
        }

        // Seats can only start from 2 , 4, 6 acc. to problem
        int[] iterablePoints = new int[]{2 , 4 , 6};

        for(int i : crowdedRows){
            for(int j : iterablePoints){
                
                if( !map.containsKey(Arrays.asList(i , j))  && !map.containsKey(Arrays.asList(i , j+1)) && !map.containsKey(Arrays.asList(i , j+2)) && !map.containsKey(Arrays.asList(i , j+3)) ){

                    map.put(Arrays.asList(i , j) , 0);
                    map.put(Arrays.asList(i , j+1) , 0);
                    map.put(Arrays.asList(i , j+2) , 0);
                    map.put(Arrays.asList(i , j+3) , 0);

                    groups++;
                }

            }
        }

        // All the seats have been checked in crowded rows
        // Now each empty row can have 2 groups
        groups += ((n - crowdedRows.size()) * 2);
        
        return groups;
    }
}