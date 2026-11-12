class Solution {
    int collide(Stack<Character> st , char ch){
        int res = 0;

        if(st.isEmpty()) st.push(ch);

        // (<-o <-o) or (o-> o->) or (<-o o->) or (S o->) or (S S)
        else if((st.peek() == 'L' && ch == 'L') || (st.peek() == 'R' && ch == 'R') || (st.peek() == 'L' && ch == 'R') || (st.peek() == 'S' && ch == 'R') || (st.peek() == 'S' && ch == 'S') || (st.peek() == 'L' && ch == 'S')) st.push(ch);

        // S <-o
        else if(st.peek() == 'S' && ch == 'L'){
            st.push('S');
            res += 1;
        }

        // o-> <-o
        else if(st.peek() == 'R' && ch == 'L'){
            st.pop();
            res += collide(st , 'S');
            st.push('S');

            res += 2;
        }

        // o-> S
        else if(st.peek() == 'R' && ch == 'S'){
            st.pop();
            res += collide(st , 'S');
            st.push(ch);
            res += 1;
        }

        // S <-o
        else if(st.peek() == 'S' && ch == 'L'){
            st.push('S');
            res += 1;
        }

        return res;
    }

    public int countCollisions(String directions) {
        Stack<Character> st = new Stack<>();

        int res = 0;

        for(char ch : directions.toCharArray()){
            res += collide(st , ch);
        }

        return res;
    }
}