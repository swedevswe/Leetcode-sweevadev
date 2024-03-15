class Solution {
    private boolean diffArrayEqual(int[] a, int[] b){
            if(a.length!=b.length) return false;
            for(int i = 0; i<a.length; i++){
                if(a[i]!=b[i]) return false;
            }
            return true;
        }
    public String oddString(String[] words) {
        int[][] diffs = new int[words.length][];
        
        for(int w = 0; w<words.length; w++){
            int n = words[w].length();
            diffs[w] = new int[n-1];
            for(int i = 0; i<n-1; i++){
                diffs[w][i] = words[w].charAt(i+1) - words[w].charAt(i);
            }
        }
    
        for(int i = 0; i<words.length; i++){
            boolean isOdd = true;
            for(int j = 0; j<words.length; j++){
                if(i!=j && diffArrayEqual(diffs[i], diffs[j])){
                    isOdd = false;
                    break;
                }
            }
            if(isOdd) return words[i];
        }
        return "";
    }
}