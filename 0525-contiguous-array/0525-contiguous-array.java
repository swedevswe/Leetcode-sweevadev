class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int count = 0;
        int max_length = 0;
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==0){
                count = count + 1;
            }else{
                count = count + -1;
            }
            if(map.containsKey(count)){
                max_length = Math.max(max_length, i-map.get(count));
            }else{
                map.put(count, i);
            }
        }
        return max_length;
    }
}