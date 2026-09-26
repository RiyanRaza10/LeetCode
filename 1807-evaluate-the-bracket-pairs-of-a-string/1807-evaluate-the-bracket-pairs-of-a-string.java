class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String , String> map = new HashMap<>();

        for(int i=0 ; i<knowledge.size() ; i++){
            map.put(knowledge.get(i).get(0) , knowledge.get(i).get(1));
        }

        StringBuilder res = new StringBuilder() , curr = new StringBuilder();

        int paren = 0;

        for(char ch : s.toCharArray()){
            if(ch == '(') paren++;
            else if(ch == ')'){
                paren--;

                if(map.containsKey(curr.toString())) res.append(map.get(curr.toString()));
                else res.append("?");

                curr = new StringBuilder();
            }

            else{
                if(paren == 0) res.append(ch);

                else curr.append(ch);
            }
        }

        return res.toString();
    }
}