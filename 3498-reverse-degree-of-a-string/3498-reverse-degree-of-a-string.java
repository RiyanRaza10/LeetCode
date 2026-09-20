class Solution {
    public int reverseDegree(String s) {
    int revDeg = 0;

    for(int i=0 ; i<s.length() ; i++){
        revDeg += (123-(int)(s.charAt(i)))*(i+1);
    }
    
    return revDeg;
    
    }
}