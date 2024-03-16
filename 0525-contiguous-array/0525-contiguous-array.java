class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int maxLength=0, balance = 0;
        
        for(int i = 0; i<nums.length; i++){
            balance = balance + (nums[i]==0 ? -1 : 1);
            
            if(map.containsKey(balance)){
                maxLength = Math.max(maxLength, i-map.get(balance));
            }else{
                map.put(balance, i);
            }
            
        }
        return maxLength;
    }
}