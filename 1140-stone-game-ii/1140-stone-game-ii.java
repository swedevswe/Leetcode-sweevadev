class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] memo = new int [n][n+1];
        int[] suffixSum = new int[n];
        
        suffixSum[n-1] = piles[n-1];
        
        for(int i = n-2; i>=0; i--){
            suffixSum[i] = suffixSum[i+1] + piles[i];
           
        }
         return helper(piles, 0, 1, memo, suffixSum);
    }
    private int helper(int[] piles, int i, int M, int[][] memo, int[] suffixSum){
        if(i>=piles.length)
            return 0;
        if(2 * M >= piles.length-i){
            return suffixSum[i];
        }
        if(memo[i][M]!=0)
            return memo[i][M];
        
        int maxStones = 0;
        
        for(int x = 1; x<=2*M; x++){
            if(i + x <= piles.length){
                int next = helper(piles, i + x, Math.max(M, x), memo, suffixSum);
                maxStones = Math.max(maxStones, suffixSum[i] - next);
            }
        }
        memo[i][M] = maxStones;
        return maxStones;
    }
}