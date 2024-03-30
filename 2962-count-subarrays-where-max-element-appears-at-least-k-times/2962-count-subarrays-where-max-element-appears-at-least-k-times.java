class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxLen = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int left = 0, maxLenInWindow = 0;
        for(int right = 0; right<nums.length; right++){
            if(nums[right]==maxLen){
                maxLenInWindow++;
            }
            while(k==maxLenInWindow){
                if(nums[left]==maxLen){
                    maxLenInWindow--;
                }
                left++;
                
            }
            ans = ans + left;
        }
        return ans;
    }
}