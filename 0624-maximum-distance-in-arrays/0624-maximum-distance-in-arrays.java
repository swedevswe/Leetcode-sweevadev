class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        //sorted array increasing order
        //distance = point a - point b = absolute difference = smallest element of one array and the largest element of another array
        //max distance
        
        int result = 0;
        int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1);
        
        for(int i = 1; i<arrays.size(); i++){
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