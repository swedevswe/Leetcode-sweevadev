class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int count = 0, prefixSum = 0;
        
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        
        prefixCount.put(0,1);
        
        for(int num : nums){
            prefixSum += num % 2;
            
            if(prefixCount.containsKey(prefixSum - k)){
                count += prefixCount.get(prefixSum - k);
            }
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum,0) + 1);
        }
        return count;
    }
}