class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        
        for(int i = 0; i<n; i++){
            dp[0][i] = grid[0][i];
        }
        
        for(int j = 1; j<n; j++){
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int minIndex = -1;
            
            for(int i = 0; i<n; i++){
                if(dp[j-1][i] < min1){
                    min2 = min1;
                    min1 = dp[j-1][i];
                    minIndex = i;
                }else if(dp[j-1][i] < min2){
                    min2 = dp[j-1][i];
                }
            }
            for(int i = 0; i<n; i++){
                if(i==minIndex){
                    dp[j][i] = grid[j][i] + min2;
                }else{
                    dp[j][i] = grid[j][i] + min1;
                }
            }
        }
            int result = Integer.MAX_VALUE;
            for(int i = 0; i<n; i++){
                result = Math.min(result, dp[n-1][i]);
            }
        return result;
    }
}