class Solution {
    public int minSteps(int n) {
       //minimize copy and paste operations
        //prime factorization of n
        //dp[i] - minimum number of steps to get i A's
        
        int[] dp = new int[n + 1];
        
        for(int i = 2; i <= n; i++){
            dp[i] = i;
            for(int j = 1; j * j <= i; j++){
                if(i % j == 0){
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                    dp[i] = Math.min(dp[i], dp[i / j] + j);
                }
            }
        }
        return dp[n];
    }
}