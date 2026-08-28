class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String , Integer> map = new HashMap<>();

        for(String s : words){
            map.put(s , map.getOrDefault(s , 0) +1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list , (a,b) -> {

            if( map.get(a) != map.get(b) ){
                return map.get(b) - map.get(a);
            }
            
            return a.compareTo(b);

        });

        List<String> res = new ArrayList<>();

        for(int i=0 ; i<k ; i++){
            res.add(list.get(i));
        }

        return res;
    }
}