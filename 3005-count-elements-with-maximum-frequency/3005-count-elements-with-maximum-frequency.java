class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int maxFreq = 0;
        for(int freq : freqMap.values()){
            maxFreq = Math.max(maxFreq, freq);
        }
        int total = 0;
        for(int freq : freqMap.values()){
            if(freq == maxFreq){
                total+=freq;
            }
        }
        return total;
    }
}
                