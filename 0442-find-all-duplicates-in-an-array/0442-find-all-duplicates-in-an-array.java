class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        
        for(int i = 0; i<nums.length; i++){
            int idx = Math.abs(nums[i])-1;
            
            if(nums[idx]<0){
                duplicates.add(idx + 1);
            }else{
                nums[idx] = -nums[idx];
            }
        }
        return duplicates;
    }
}