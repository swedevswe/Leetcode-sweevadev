class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        
        HashMap <Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);
        for(int num : nums){
            sum = sum + num;
            if(prefixSum.containsKey(sum-goal)){
                count = count + prefixSum.get(sum-goal);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}