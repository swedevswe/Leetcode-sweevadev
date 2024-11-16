class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];
        
        for(int i = 0; i <= n - k; i++){
            int[] subarray = new int[k];
            for(int j = 0; j < k; j++){
                subarray[j] = nums[i + j];
            }
            if(isConsecutiveAndSorted(subarray, k)){
                results[i] = findMax(subarray);
            }else{
                results[i] = -1;
            }
        }
        return results;
    }
    private boolean isConsecutiveAndSorted(int[] subarray, int k){
        int min = findMin(subarray);
        int max = findMax(subarray);
        
        if(max - min != k - 1){
            return false;
        }
        for(int i = 0; i < subarray.length - 1; i++){
            if(subarray[i] >= subarray[i+1]){
                return false;
            }
        }
        boolean[] seen = new boolean[k];
        for(int num : subarray){
            if(num < min || num > max){
                return false;
            }
            seen[num - min] = true;
        }
        for(boolean s : seen){
            if(!s){
                return false;
            }
        }
        return true;
    }
    private int findMax(int[] array){
        int max = array[0];
        for(int num : array){
            max = Math.max(max, num);
        }
        return max;
    }
    private int findMin(int[] array){
        int min = array[0];
        for(int num : array){
            min = Math.min(min, num);
        }
        return min;
    }
}