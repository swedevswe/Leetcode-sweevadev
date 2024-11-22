class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int maxRows = 0;
        for(int[] targetRow : matrix){
            int count = 0;
            for(int[] row : matrix){
                if(canBeMadeEqual(targetRow, row)){
                    count++;
                }
            }
            maxRows = Math.max(maxRows, count);
        }
        return maxRows;
    }
    private static boolean canBeMadeEqual(int[] targetRow, int[] row){
        int n = targetRow.length;
        int flipPattern = row[0] ^ targetRow[0];
        for(int i = 1; i < n; i++){
            if((row[i] ^ targetRow[i]) != flipPattern){
                return false;
            }
        }
        return true;
    }
}