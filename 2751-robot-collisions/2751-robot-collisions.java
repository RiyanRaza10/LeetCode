class Pair{
    int health;
    char dir;
    Pair(int health , char dir){
        this.health = health;
        this.dir = dir;
    }
}

class Solution {

    void solve(HashMap<Integer , Pair> map , Stack<Integer> st , boolean[] killed , HashMap<Integer , Integer> indMap , char ch , int currPos){
        if(st.isEmpty()) st.push(currPos);

        // (o-> o->) or (<-o <-o) or (<-o o->)
        else if((map.get(st.peek()).dir == 'R' && ch == 'R') || (map.get(st.peek()).dir == 'L' && ch == 'L') || (map.get(st.peek()).dir == 'L' && ch == 'R')) st.push(currPos);

        else {
            int currHealth = Math.abs(map.get(currPos).health);
            int prevHealth = Math.abs(map.get(st.peek()).health);
            
            // Both of equal health
            if(prevHealth == currHealth){
                int removed = st.pop();
                killed[indMap.get(removed)] = true;
                killed[indMap.get(currPos)] = true;
            }
            
            // Previous one dominates
            else if(prevHealth > currHealth){
                int prev = map.get(st.peek()).health;
                map.get(st.peek()).health = prev-1;
                killed[indMap.get(currPos)] = true; 
            }

            // Current dominates , collide all possibles to the left with curr
            else{
                int removed = st.pop();
                killed[indMap.get(removed)] = true;

                int prev = map.get(currPos).health;
                map.get(currPos).health = prev-1;

                // Recusively solve
                solve(map , st , killed , indMap , ch , currPos);
            }
        }
    }


    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        // To map position and track healths and directions
        HashMap<Integer , Pair> map = new HashMap<>();

        // To keep track of who got killed , maps position to original index
        HashMap<Integer , Integer> indMap = new HashMap<>();
        boolean[] killed = new boolean[n];
        
        // Since we are making changes to original positions , this will store them for future checking
        int[] prevPos = new int[n];
        
        for(int i=0 ; i<n ; i++){
            prevPos[i] = positions[i];
            indMap.put(positions[i] , i);
        }

        for(int i=0 ; i<n ; i++) map.put(positions[i] , new Pair(healths[i] , directions.charAt(i)));

        Arrays.sort(positions);
        StringBuilder newDir = new StringBuilder();

        for(int i=0 ; i<n ; i++){
            healths[i] = map.get(positions[i]).health;
            newDir.append(map.get(positions[i]).dir);
        }

        Stack<Integer> st = new Stack<>();

        for(int i=0 ; i<n ; i++){
            solve(map , st , killed , indMap , newDir.charAt(i) , positions[i]);
        }

        List<Integer> res = new ArrayList<>();

        // All all the healths of robots , that are not killed
        for(int i=0 ; i<n ; i++){
            if(!killed[i]){
                res.add(map.get(prevPos[i]).health);
            }
        }

        return res;
    }
}