class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        
        for(int i = 0; i<m; i++){
            int minRowVal = matrix[i][0];
            int minRowIndex = 0;
            for(int j = 1; j<n; j++){
                if(matrix[i][j] < minRowVal){
                    minRowVal = matrix[i][j];
                    minRowIndex = j;
                }
            }
            boolean isMaxInCol = true;
            for(int j = 0; j<m; j++){
                if(matrix[j][minRowIndex] > minRowVal){
                    isMaxInCol = false;
                    break;
                }
            }
            if(isMaxInCol){
                luckyNumbers.add(minRowVal);
            }
        }
        return luckyNumbers;
    }
}