class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> seen = new HashSet<>();
        for(int num : nums1){
            seen.add(num);
            
        }
        Set<Integer> result = new HashSet<>();
        for(int num : nums2){
            if(seen.contains(num)){
                result.add(num);
            }
        }
        int[] ans = new int[result.size()];
        int i = 0;
        for(int num : result){
            ans[i++] = num;
        }
        return ans;
    }
}