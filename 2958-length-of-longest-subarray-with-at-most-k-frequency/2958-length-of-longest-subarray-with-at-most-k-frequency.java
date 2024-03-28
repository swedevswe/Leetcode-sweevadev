class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for(int right = 0; right<nums.length; right++){
            freq.put(nums[right], freq.getOrDefault(nums[right],0)+1);
            while(freq.get(nums[right])>k){
                freq.put(nums[left], freq.get(nums[left])-1);
                if(freq.get(nums[left])==0){
                    freq.remove(nums[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            
        }
        return maxLen;
    }
}