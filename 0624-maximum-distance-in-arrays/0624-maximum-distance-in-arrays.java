class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        //distance = max - min;
        
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);
        
        int result = 0;
        
        for(int i = 1; i < arrays.size(); i++){
            List<Integer> current = arrays.get(i);
            int currMin = current.get(0);
            int currMax = current.get(current.size() - 1);
            
            result = Math.max(result, Math.max(Math.abs(max - currMin), Math.abs(currMax - min)));
            
            min = Math.min(min, currMin);
            max = Math.max(max, currMax);
        }
        return result;
    }
}