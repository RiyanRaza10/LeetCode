class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> validOperations = new ArrayList<>();

        solve(validOperations , new ArrayList<>() , new ArrayList<>() , new ArrayList<>() , num , target , 0);

        return validOperations;
    }

    long evaluateExp(List<String> curr , List<Character> operators , List<Long> numbers){

        // Empty operation
        if(curr.size() == 0) return 0L;

        HashMap<Integer , Long> map = new HashMap<>();

        long mul = 0;
        int start = -1;

        // First evaluate all multiplications
        for(int i=0 ; i<operators.size() ; i++) {
            char op = operators.get(i);

            if(op == '*'){
                if(mul == 0 && start == -1){
                    start = i;

                    mul = numbers.get(i) * numbers.get(i+1);

                    
                    map.put(start , mul);        
                }

                else if(mul != 0){
                    mul *= numbers.get(i+1);
                    map.put(start , mul);
                }

            }

            else{
                start = -1;
                mul = 0;
            }

        }

        long res = numbers.get(0);

        int numInd = 1;

        // if operation starts with multiplication
        if(map.containsKey(0)){
            res = map.get(0);

            while(numInd - 1 < operators.size() && operators.get(numInd-1) == '*') numInd++;

        }


        while(numInd < numbers.size()){
            char op = operators.get(numInd-1);

            // overflow
            if(res > Integer.MAX_VALUE) return 0L;

            if(op == '-'){
                if(!map.containsKey(numInd)) res -= numbers.get(numInd);

                else{ // Already calculated multiplication
                    res -= map.get(numInd);

                    while(numInd < operators.size() && operators.get(numInd) == '*') numInd++;
                    
                }
            }

            else if(op == '+'){
                if(!map.containsKey(numInd)) res += numbers.get(numInd);

                else{  // Already calculated multiplication
                    res += map.get(numInd);

                    while(numInd < operators.size() && operators.get(numInd) == '*') numInd++;
                }
            }

            numInd++;
        }

        return res;

    }

    void solve(List<String> validOperations , List<String> curr , List<Character> operators , List<Long> numbers , String num , int target , int ind){

        // Partitioned till last
        if(ind == num.length()){

            long currAns = evaluateExp(curr , operators , numbers);

            if(currAns == target){
                StringBuilder comb = new StringBuilder();

                for(String s : curr) comb.append(s);

                validOperations.add(comb.toString());
            }

            return;
        }

        for(int i=ind ; i<num.length() ; i++){
            String s = num.substring(ind , i+1);
            long currNum = Long.parseLong(s);

            if(s.length() > 1 && s.charAt(0) == '0') continue;

            if(curr.size() == 0){
                curr.add(s);
                numbers.add(currNum);

                solve(validOperations , curr , operators , numbers , num , target , i+1);

                curr.remove(curr.size()-1);
                numbers.remove(numbers.size()-1);
            }

            else{
                // Multiplication
                curr.add("*");
                curr.add(s);
                numbers.add(currNum);
                operators.add('*');

                solve(validOperations , curr , operators , numbers , num , target , i+1);

                curr.remove(curr.size()-1);
                curr.remove(curr.size()-1);
                numbers.remove(numbers.size()-1);
                operators.remove(operators.size()-1);
                
                // Addition
                curr.add("+");
                curr.add(s);
                numbers.add(currNum);
                operators.add('+');

                solve(validOperations , curr , operators , numbers , num , target , i+1);

                curr.remove(curr.size()-1);
                curr.remove(curr.size()-1);
                numbers.remove(numbers.size()-1);
                operators.remove(operators.size()-1);

                // Subtraction
                curr.add("-");
                curr.add(s);
                numbers.add(currNum);
                operators.add('-');

                solve(validOperations , curr , operators , numbers , num , target , i+1);

                curr.remove(curr.size()-1);
                curr.remove(curr.size()-1);
                numbers.remove(numbers.size()-1);
                operators.remove(operators.size()-1);
            }
        }  

    }

}