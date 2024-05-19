class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long totalSum = 0;
        long totalGain = 0;
        int minPositiveGain = Integer.MAX_VALUE;
        int maxNegativeGain = Integer.MIN_VALUE;
        int positiveCount = 0;
        
        for(int num : nums){
            int xorVal = num ^ k;
            int gain = xorVal - num;
            totalGain += num;

        if(gain > 0){
            totalGain += gain;
            
            minPositiveGain = Math.min(minPositiveGain, gain);
            positiveCount++;
        }else{
            maxNegativeGain = Math.max(maxNegativeGain, gain);
            
            
        }
        }
        if(positiveCount % 2 == 0){
            return totalSum + totalGain;
        }
        return Math.max(totalSum + totalGain - minPositiveGain, totalSum + totalGain + maxNegativeGain);
    }
}