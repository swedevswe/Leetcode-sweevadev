class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        if(k == 0) return result;
        int[] doubled = new int[n * 2];
        for(int i = 0; i < n * 2; i++){
            doubled[i] = code[i % n];
        }
        int windowSum = 0;
        if(k > 0){
            for(int i = 1; i <= k; i++){
                windowSum += doubled[i];
            }
            for(int i = 0; i < n; i++){
                result[i] = windowSum;
                windowSum -= doubled[i + 1];
                windowSum += doubled[i + k + 1];
            }
        }else{
            k = -k;
            for(int i = n - k; i < n; i++){
                windowSum += doubled[i];
            }
            for(int i = 0; i < n; i++){
                result[i] = windowSum;
                windowSum -= doubled[n - k + i];
                windowSum += doubled[n + i];
            }
        }
        return result;
    }
}