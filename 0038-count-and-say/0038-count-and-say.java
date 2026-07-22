class Solution {

    String RLE(String s){
        StringBuilder res = new StringBuilder();
        
        int count = 1;
        char ch = s.charAt(0);

        for(int i= 1 ; i<s.length() ; i++){
            if(s.charAt(i) == ch){
                count++;
            }
            else{
                res.append(count).append(ch);
                ch = s.charAt(i);
                count = 1;

            }
        }
        res.append(count).append(ch);

        return res.toString();
    }

    public String countAndSay(int n) {
        StringBuilder num = new StringBuilder("1");
        int cnt = 1;

        while(cnt < n){
            num = new StringBuilder(RLE(num.toString()));
            cnt++;
        }

        return num.toString();
    }
}