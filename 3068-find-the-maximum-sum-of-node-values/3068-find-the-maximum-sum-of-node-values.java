class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long totalSum = 0;
        long totalGain = 0;
        int minPositiveGain = Integer.MAX_VALUE;
        int maxNegativeGain = Integer.MIN_VALUE;
        int positiveCount = 0;

        for (int num : nums) {
            int xorValue = num ^ k;
            int gain = xorValue - num;
            totalSum += num;

            if (gain > 0) {
                totalGain += gain;
                minPositiveGain = Math.min(minPositiveGain, gain);
                positiveCount++;
            } else {
                maxNegativeGain = Math.max(maxNegativeGain, gain);
            }
        }

        // If the number of positive gains is even, return the total sum with all gains.
        if (positiveCount % 2 == 0) {
            return totalSum + totalGain;
        }

        // If the number of positive gains is odd, we adjust by removing the smallest positive gain or adding the largest negative gain.
        return Math.max(totalSum + totalGain - minPositiveGain, totalSum + totalGain + maxNegativeGain);
    }
}
