class Solution {
    public List<String> printVertically(String s) {
        List<String> list = new ArrayList<>();

        //Putting all words in an array
        String []arr = s.split(" ");

        int max_len = 0 ;

        //Size of ArrayList
        for(int i=0 ; i<arr.length ; i++){
           max_len = Math.max(arr[i].length() , max_len);
        }

        for(int i=0 ; i<max_len ; i++){
            
            StringBuilder word = new StringBuilder();

            for(int j=0 ; j<arr.length ; j++){
                if(i < arr[j].length()) word.append(arr[j].charAt(i));
                else word.append(" ");
            }

            // ALTERNATE METHOD TO REMOVE RIGHT TRAILING SPACES 
            // int ind = word.length()-1;
            // while(word.charAt(ind) == ' '){
            //     ind--;
            // }
            // list.add(word.substring(0,ind+1).toString());

            // stripTrailing() -> Removes trailing spaces from right side of string
            list.add(word.toString().stripTrailing());
        
        }
        
        return list;
    }
}