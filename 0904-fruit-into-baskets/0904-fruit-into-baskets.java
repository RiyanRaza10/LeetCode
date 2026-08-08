class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer , Integer> map = new HashMap<>();

        int left = 0 , right = 0 , maxLen = 0;

        while(right < fruits.length){
            map.put(fruits[right] , map.getOrDefault(fruits[right] , 0) + 1);

            // Shrinking so that map contains at max 2 type of fruits
            while(left <= right && map.size() > 2){
                map.put(fruits[left] , map.get(fruits[left]) - 1);

                if(map.get(fruits[left]) <= 0) map.remove(fruits[left]);

                left++;
            }

            maxLen = Math.max(maxLen , right - left + 1);

            right++;
        }

        return maxLen;
    }
}