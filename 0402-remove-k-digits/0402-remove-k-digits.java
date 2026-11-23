class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> dq = new ArrayDeque<>();

        for(char ch : num.toCharArray()){

            while(!dq.isEmpty() && dq.peekLast() > ch && k > 0){
                dq.pollLast();
                k--;
            }

            dq.offerLast(ch);
        }

        while(k-- > 0 && !dq.isEmpty()) dq.pollLast();
        while(!dq.isEmpty() && dq.peekFirst() == '0') dq.pollFirst();

        StringBuilder res = new StringBuilder();
        while(!dq.isEmpty()) res.append(dq.pollFirst());

        return res.length() == 0 ? "0" : res.toString();
    }
}