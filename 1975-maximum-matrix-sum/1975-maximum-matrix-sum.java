class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negCount = 0;
        long minAbsVal = Long.MAX_VALUE;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                sum += Math.abs(matrix[i][j]);
                if(matrix[i][j] < 0){
                    negCount++;
                }
                minAbsVal = Math.min(minAbsVal, Math.abs(matrix[i][j]));
            }
        }
        if(negCount % 2 == 0){
            return sum;
        }else{
            return sum - 2 * minAbsVal;
        }
    }
}