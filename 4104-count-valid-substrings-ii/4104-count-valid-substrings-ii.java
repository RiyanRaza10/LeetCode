class Solution {
    public long countValidSubstrings(String s) {
        long res = 0;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        int a = 0 , b = 0 , c = 0;
        int left = 0 , right = 0;

        while(right < s.length()){
            char ch = s.charAt(right);

            if(ch == 'a'){
                a++;
                l1.add(right);
            }
            else if(ch == 'b'){
                b++;
                l2.add(right);
            }
            else{
                // l1 : 4 6 7
                // l2 : 2 5
                while(a > 0 && b > 0 && l1.get(0) < l2.get(l2.size()-1)){
                    char cL = s.charAt(left);
                    if(cL == 'a') 
                    {
                        l1.remove(0);
                        a--;
                    }
                    else if(cL == 'b'){
                        l2.remove(0);
                        b--;
                    }
                    else c--;

                    left++;
                }

                c++;
            }

            res += right - left + 1;
            right++;
        }

        return res;
    }
}