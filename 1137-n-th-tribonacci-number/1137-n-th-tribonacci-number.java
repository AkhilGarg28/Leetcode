class Solution {
    public int solve(int n , int[] dp){
        if(n ==0) return 0;
        if(n<=2) return 1;
        if (dp[n] != -1) return dp[n];

        int a = solve(n-1, dp);
        int b = solve(n -2, dp);
        int c = solve(n -3, dp);
        return dp[n] = a+b+c;
    }
    public int tribonacci(int n) {
        int dp[] = new int[n+1];
        for(int i=0; i<n+1;i++){
            dp[i] = -1;
        }
        return solve(n , dp);
    }
}