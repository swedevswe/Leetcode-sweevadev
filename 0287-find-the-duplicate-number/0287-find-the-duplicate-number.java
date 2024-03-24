class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                return num;
            }map.put(num, true);
        }
        return -1;
    }
}