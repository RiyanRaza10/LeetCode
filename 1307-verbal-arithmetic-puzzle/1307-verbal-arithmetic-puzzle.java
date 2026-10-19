// Key Idea : Pehle last column of words ke letters ko map kro
//            Fir check kro mapping ka sum should equal corresponding letter of result
//            Using this approach , we can prune backtracking
//            First letter of word should'nt be zero {except when word length is 1}
class Solution {
    public boolean isSolvable(String[] words, String result){
        // Agar kisi word ki length result se badi hogyi , mapping is impossible
        for(String word : words){
            if(word.length() > result.length()) return false;
        }

        // To keep track of used digits
        boolean[] used = new boolean[10];

        HashMap<Character , Integer> map = new HashMap<>();

        return solve(words , result , map , used , 0 , -1 , 0 , 0);
    }

    boolean solve(String[] words , String result , HashMap<Character , Integer> map , boolean[] used , int row , int col , int colSum , int carry){

        // All columns mapped , check if carry is also used
        if(col == result.length() * (-1) - 1){
            return carry == 0;
        }

        // Column wise words of left side of current column mapped , check for result's character
        if(row == words.length){

            // Current character of result is already mapped
            if(map.containsKey(result.charAt(result.length()+col))){

                // Check if first letter of result is already mapped as 0
                if(col * (-1) == result.length() && map.get( result.charAt(result.length()+col) ) == 0 && result.length() > 1) return false;
                
                // Check if mapped character , equals (colSum % 10) {carry hata ke}
                if(map.get(result.charAt(result.length()+col)) == (colSum + carry)%10){
                    if(solve(words , result , map , used , 0 , col-1 , 0 , (colSum + carry) / 10)) return true;
                }

                // Wrong map krdiya , go back
                else return false;
            }

            // Map kro
            else{
                // Required digit for result's character is (colSum + carry)%10
                if(!used[(colSum + carry)%10]){
                    
                    // Check for first character of result(should'nt be mapped to 0)
                    if(((colSum + carry) % 10) == 0 && col * (-1) == result.length() && result.length() > 1) return false;
                    
                    // Pick
                    used[(colSum + carry) % 10] = true;
                    map.put(result.charAt(result.length()+col) , (colSum + carry) % 10);

                    // Recursive call for next column
                    if(solve(words , result , map , used , 0 , col-1 , 0 , (colSum + carry) / 10)) return true;
                    
                    // Backtrack
                    map.remove(result.charAt(result.length()+col));
                    used[(colSum + carry) % 10] = false;        
                }

                // Couldn't map this result's character , go back
                else return false;
            }
        }

       
        // Check if column does'nt exceed current word's length  
        else if(col*(-1) <= words[row].length()){

            // Character already mapped
            if(map.containsKey(words[row].charAt(words[row].length()+col))){

                // Check if mapped character is the first letter of current words && mapped as 0
                if(col * (-1) == words[row].length() && map.get(words[row].charAt(words[row].length() + col)) == 0 && words[row].length() > 1) return false;
                
                // Recursive call for next row
                if(solve(words , result , map , used , row+1 , col , (colSum + map.get(words[row].charAt(words[row].length()+col))) , carry)) return true;

            }

            else{
                // Map this left side character
                for(int i=0 ; i<10 ; i++){
                    if(!used[i]){
                    
                    // Starting character shouldn't be zero
                    if(col == words[row].length()*(-1) && i == 0 && words[row].length() > 1) continue;

                    // Pick
                    map.put(words[row].charAt(words[row].length() + col) , i);
                    used[i] = true;

                    // Recursive call to next row
                    if(solve(words, result , map, used , row+1 , col , (colSum + i) , carry)) return true;

                    // Backtrack
                    map.remove(words[row].charAt(words[row].length()+col));
                    used[i] = false;

                    }
                }
            }
        }

        // current row/word ke liye column exceed kr gaya , call next row
        else{
            if(solve(words, result , map, used , row+1 , col , colSum , carry)) return true;
        }
           
        // No valid Mappings
        return false;
    }
}