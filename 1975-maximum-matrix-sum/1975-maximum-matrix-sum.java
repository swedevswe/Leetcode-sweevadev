class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int negativeCount = 0;
        int minAbsVal = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sum += Math.abs(matrix[i][j]);
                if(matrix[i][j] < 0){
                    negativeCount++;
                }
                minAbsVal = Math.min(minAbsVal, Math.abs(matrix[i][j]));
            }
        }
        if(negativeCount % 2 == 0){
            return sum;
        }else{
            return sum - 2 * minAbsVal;
        }
    }
}