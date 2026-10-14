class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder res = new StringBuilder();

        int digitCnt = 0;
        int digitSum = 0;
        int digit = 9;

        while(digitSum < sum && digitCnt < num){

            while(digit >= 0 && digitSum + digit <= sum){
                digitSum += digit;
                digitCnt++;

                res.append(digit);
            }

            // Reduce digit
            if(digitSum + digit > sum) digit--;
        }

        // Append zeroes if length of res is less than num
        while(res.length() < num) res.append(0);

        // digitSum should be exactly sum
        if(digitSum == sum) return res.toString();

        // A number cannot be formed
        return "";
    }
}