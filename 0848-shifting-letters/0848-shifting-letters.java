class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        long totalShifts = 0;

        StringBuilder res = new StringBuilder();

        for(int i=n-1 ; i>=0 ; i--){
            totalShifts += shifts[i];

            // To avoid overflow
            totalShifts %= 26; 

            // Shifted char
            int shiftedChar = (int)totalShifts + s.charAt(i);  
            
            res.append(shiftedChar <= 122 ? (char)shiftedChar : (char)(shiftedChar - 26));
            
        }

        return res.reverse().toString();

    }
}