class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxFreq = 0;
        
        for(int i = 0; i<nums.length; i++){
            int count = 0;
            for(int j = 0; j<nums.length; j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            maxFreq = Math.max(maxFreq, count);
        }
        int totalMaxFreq = 0;
        for(int i = 0; i<nums.length; i++){
            int count = 0;
            for(int j = 0; j<nums.length; j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count == maxFreq){
                boolean isFirstOccurence = true;
                for(int k = 0; k<i; k++){
                    if(nums[k] == nums[i]){
                        isFirstOccurence = false;
                        break;
                    }
            }
                       if(isFirstOccurence){
                           totalMaxFreq = totalMaxFreq + count;
                       }
        }
                       }
                       return totalMaxFreq;
}
                       }