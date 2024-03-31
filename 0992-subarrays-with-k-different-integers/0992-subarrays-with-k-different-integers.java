class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
    private int atMostKDistinct(int[] nums, int k){
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0, result = 0;
        for(int right = 0; right<nums.length; right++){
            count.put(nums[right], count.getOrDefault(nums[right],0)+1);
            while(count.size()>k){
                count.put(nums[left], count.get(nums[left])-1);
                if(count.get(nums[left])==0){
                    count.remove(nums[left]);
                }
                left++;
            }
            result = result + right - left + 1;
        }
        return result;
    }
}