class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        
        int[][] memo = new int[n][n];
        for(int col = 0; col<n; col++){
            memo[n-1][col] = grid[n-1][col];
        }
        
        for(int row = n-2; row>=0; row--){
            for(int col=0; col<n; col++){
                int nextMin = Integer.MAX_VALUE;
                for(int nextRowCol = 0; nextRowCol<n; nextRowCol++){
                    if(nextRowCol != col){
                        nextMin = Math.min(nextMin, memo[row+1][nextRowCol]);
                    }
                    
                }
                memo[row][col] = grid[row][col] + nextMin;
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int col = 0; col<n; col++){
            answer = Math.min(answer, memo[0][col]);
        }
        return answer;
    }
}