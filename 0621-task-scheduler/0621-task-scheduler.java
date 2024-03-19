class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char task : tasks){
            freqMap.put(task, freqMap.getOrDefault(task,0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(freqMap.values());
        
        int cycles = 0;
        while(!maxHeap.isEmpty()){
            List<Integer>temp = new ArrayList<>();
            for(int i = 0; i<=n; i++){
                if(!maxHeap.isEmpty()){
                    temp.add(maxHeap.remove());
                }
            }
            for(int freq : temp){
                if(--freq > 0){
                    maxHeap.add(freq);
                }
            }
            cycles += maxHeap.isEmpty() ? temp.size(): n+1;
            
        }
        return cycles;
            
        }
    }
