class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return goodSubArray(nums, k) - goodSubArray(nums, k - 1);
    }
    private int goodSubArray(int[] nums, int k){
        Map<Integer, Integer> freq = new HashMap<>();
        int ans = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            freq.put(nums[right], freq.getOrDefault(nums[right],0)+1);
            while(freq.size()>k){
                freq.put(nums[left], freq.get(nums[left])-1);
                if(freq.get(nums[left])==0){
                    freq.remove(nums[left]);
                }
                left++;
            }
            ans = ans + right - left + 1;
        }
        return ans;
    }
}