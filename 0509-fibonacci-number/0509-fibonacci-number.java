class Solution {
    public static int solve(int n, int[] dp){
        if(n<=1) return n;

        if(dp[n]!=-1){
            return dp[n];
        }
        int a = solve(n-1, dp);
        int b = solve(n-2, dp);
        return dp[n] = a+b;
    }
    public int fib(int n) {
        int[] dp = new int [n+1];
        for(int i =0;i<n+1; i++){
            dp[i]= -1;
        }
        return solve(n , dp);
    }
}