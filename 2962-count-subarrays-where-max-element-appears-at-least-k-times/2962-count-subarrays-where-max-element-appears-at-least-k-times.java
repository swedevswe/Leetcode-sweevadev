class Solution {
    public long countSubarrays(int[] nums, int k) {
        
      int maxLen = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int start = 0, maxElementInWindow = 0;
        
        for(int end = 0; end<nums.length; end++){
            if(nums[end]==maxLen){
                maxElementInWindow++;
            }
            while(k==maxElementInWindow){
                if(nums[start]==maxLen){
                    maxElementInWindow--;
                }
                start++;
            }
            ans = ans + start;
        }
        return ans;
    }
}