class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currSum = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
            
            while(set.contains(nums[i])){
                currSum -= nums[i - set.size()];
                set.remove(nums[i - set.size()]);
            }
            set.add(nums[i]);
            if(set.size() > k){
                currSum -= nums[i - k];
                set.remove(nums[i - k]);
            }
            if(set.size() == k){
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }
}