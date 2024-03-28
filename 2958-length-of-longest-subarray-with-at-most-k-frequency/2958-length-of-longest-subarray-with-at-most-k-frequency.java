class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxLen = 0;
        int left = -1;
        Map<Integer, Integer> freq = new HashMap<>();
        
        
        for(int right = 0; right<nums.length; right++){
            freq.put(nums[right], freq.getOrDefault(nums[right],0)+1);
            while(freq.get(nums[right])>k){
                left++;
                freq.put(nums[left], freq.get(nums[left])-1);
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}