class Solution {

    char SHIFT(char ch , long n){
        
        long shift = (int)(ch) + n ;
        
        // if(shift > 122){
        //     shift -= 26;
        // }
        // return (char)(shift);

        return shift <= 122 ? (char)(shift) : (char)(shift-26) ;
    }

    public String shiftingLetters(String s, int[] shifts) {
        
        long total_shifts = 0;

        StringBuilder res = new StringBuilder();

        // Precomputing total shifts
        for(int val : shifts){
            // As val can be too large 
            total_shifts += (val % 26);
        }

        // Shifting 
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);   
            
            // Shifting character (mod is used to prevent overflow of letters)
            res.append( SHIFT(ch , total_shifts%26 ) );
            
            // Reducing shifts for each character (mod is used to prevent overflow of letters)
            total_shifts -= (shifts[i] % 26);
            
        }

        return res.toString();

    }
}