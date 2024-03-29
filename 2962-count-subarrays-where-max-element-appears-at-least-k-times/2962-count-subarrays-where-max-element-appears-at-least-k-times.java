class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxLen = Arrays.stream(nums).max().getAsInt();
        List<Integer> indexOfMaxElement = new ArrayList<>();
        long ans = 0;
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==maxLen){
                indexOfMaxElement.add(i);
            }
            int freq = indexOfMaxElement.size();
            if(freq>=k){
                ans = ans + indexOfMaxElement.get(freq-k)+1;
            }
        }
        return ans;
    }
}