class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer , Integer> map = new HashMap<>();

        int left = 0 , right = 0 , minLen = Integer.MAX_VALUE;

        while(right < cards.length){
            map.put(cards[right] , map.getOrDefault(cards[right] , 0) + 1);

            while(left <= right && map.get(cards[right]) > 1){
                minLen = Math.min(minLen , right - left + 1);

                map.put(cards[left] , map.get(cards[left]) - 1);

                if(map.get(cards[left]) == 0) map.remove(cards[left]);

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}