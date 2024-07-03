class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> mapCount = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();
        
        for(int num : nums1){
            mapCount.put(num, mapCount.getOrDefault(num, 0) + 1);
        }
        for(int num : nums2){
            if(mapCount.getOrDefault(num, 0) > 0){
                intersection.add(num);
                mapCount.put(num, mapCount.get(num) - 1);
            }
        }
        int[] result = new int[intersection.size()];
        for(int i = 0; i<intersection.size(); i++){
            result[i] = intersection.get(i);
        }
        return result;
    }
}