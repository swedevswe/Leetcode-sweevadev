class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        
        // Base case: if k is 0, return array of zeros
        if (k == 0) return result;
        
        // Create a doubled array to handle circular nature
        int[] doubled = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            doubled[i] = code[i % n];
        }
        
        // Initialize window sum
        int windowSum = 0;
        
        if (k > 0) {
            // Calculate initial window sum for positive k
            for (int i = 1; i <= k; i++) {
                windowSum += doubled[i];
            }
            
            // Slide window for each position
            for (int i = 0; i < n; i++) {
                result[i] = windowSum;
                windowSum -= doubled[i + 1];
                windowSum += doubled[i + k + 1];
            }
        } else {
            // Calculate initial window sum for negative k
            k = -k;  // Make k positive for easier handling
            for (int i = n - k; i < n; i++) {
                windowSum += doubled[i];
            }
            
            // Slide window for each position
            for (int i = 0; i < n; i++) {
                result[i] = windowSum;
                windowSum -= doubled[n - k + i];
                windowSum += doubled[n + i];
            }
        }
        
        return result;
    }
}
