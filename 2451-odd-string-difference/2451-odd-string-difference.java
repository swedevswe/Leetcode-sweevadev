class Solution {
    public String oddString(String[] words) {
        int[][] matrix = new int[words.length][words[0].length()];
        for(int i = 0; i<words.length; i++){
            String word = words[i];
            for(int j = 0; j<word.length()-1; j++){
                matrix[i][j] = word.charAt(j+1) - word.charAt(j);
            }
        }
        for(int i = 1; i<matrix.length-1; i++){
            int[] prev = matrix[i-1], cur = matrix[i], next = matrix[i+1];
            
            if(Arrays.equals(prev, cur) && !Arrays.equals(cur, next)){
                return words[i+1];
            }
             if(Arrays.equals(cur, next) && !Arrays.equals(cur, prev)){
                return words[i-1];
            }
             if(Arrays.equals(prev, next) && !Arrays.equals(cur, prev)){
                return words[i];
            }
        }
        return "";
    }
}