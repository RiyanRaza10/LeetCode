class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Double> pq = new PriorityQueue<>();

        double ansRatio = 0;
        
        for(int i=0; i<arr.length ; i++){
            for(int j=i+1 ; j<arr.length ; j++){
                double ratio = (double)(arr[i]) / arr[j];

                pq.add(ratio);
            }
        }

        while(!pq.isEmpty() && k-- > 0){
            ansRatio = pq.poll();
        }

        for(int i=0; i<arr.length ; i++){
            for(int j=i+1 ; j<arr.length ; j++){
                double ratio = (double)(arr[i]) / arr[j];

                if(ratio == ansRatio) return new int[]{arr[i] , arr[j]};
            }
        }

        return new int[]{-1 , -1};
    }
}