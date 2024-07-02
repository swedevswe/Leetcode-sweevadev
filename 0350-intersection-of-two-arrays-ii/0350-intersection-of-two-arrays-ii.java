class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();
        
        for(int num : nums1){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for(int num : nums2){
            if(countMap.getOrDefault(num, 0) > 0){
                intersection.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }
        int[] result = new int[intersection.size()];
        for(int i = 0; i<intersection.size(); i++){
            result[i] = intersection.get(i);
        }
        return result;
        
    }
}