class Solution {
    int Tribo(int n){
        if(n == 0)return 0;
        if(n == 1 || n == 2) return 1;
        int T_0 = 0 , T_1 = 1 , T_2 = 1 , T_n = 0;

        for(int i=0 ; i<n-2 ; i++){
            T_n = T_0 + T_1 + T_2;

            T_0 = T_1;
            T_1 = T_2;
            T_2 = T_n;
            
        }
        return T_n; 
    }
    public int tribonacci(int n) {
    int T_0 = 0 , T_1 = 1 , T_2 = 1;

    return Tribo(n);
    }
}