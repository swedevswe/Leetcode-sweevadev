class Solution {
    public String oddString(String[] words) {
        int[][] matrix = new int[words.length][words[0].length()-1];
            for(int i = 0; i<words.length; i++){
                String word = words[i];
                for(int j = 0; j<word.length()-1; j++){
                    matrix[i][j] = word.charAt(j+1) - word.charAt(j);
                }
            }
            
            if(!Arrays.equals(matrix[0], matrix[1])){
                if(Arrays.equals(matrix[1], matrix[2])){
                    return words[0];
                }else{
                    return words[1];
                }
            }
        for(int i = 1; i<matrix.length; i++){
            if(!Arrays.equals(matrix[i], matrix[i-1])){
                return words[i];
            }
        }
        return "";
    }
}