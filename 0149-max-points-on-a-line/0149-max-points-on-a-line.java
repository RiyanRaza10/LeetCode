class Solution {
    public int maxPoints(int[][] points) {
        HashMap<Double,Integer> map = new HashMap<>();

        int max_points = 1;

        for(int i=0 ; i<points.length ; i++){
            for(int j=0 ; j<points.length ; j++){
                
                if(j != i){
                    double y = (double)points[j][1] - points[i][1];
                    double x = (double)points[j][0] - points[i][0];

                    if(x == 0){

                        if(!map.containsKey(Double.MAX_VALUE)) map.put(Double.MAX_VALUE , 2);

                        else
                        map.put(Double.MAX_VALUE, map.get(Double.MAX_VALUE) + 1 );
                    }

                    else{
                        double ratio = (double)y / x;

                        if(!map.containsKey(ratio)) map.put(ratio , 2);

                        else map.put(ratio , map.get(ratio) + 1);
                    }
                }
            }

            for(int val : map.values()){
                max_points = Math.max(max_points , val);
            }

            // To avoid using same points
            map.clear();
        }

        return max_points;
    }
}