class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int lastMin = -1, lastMax = -1;
        int left = 0;
        long ans = 0;
        
        for(int right = 0; right<nums.length; right++){
            if(nums[right]<minK || nums[right]>maxK){
                left = right + 1;
            }
            if(nums[right]==minK){
                lastMin = right;
            }
            if(nums[right]==maxK){
                lastMax = right;
            }
            if(lastMin!=-1 && lastMax != -1){
                ans = ans + Math.max(0, Math.min(lastMin, lastMax) - left + 1);
            }
        }
        return ans;
    }
}