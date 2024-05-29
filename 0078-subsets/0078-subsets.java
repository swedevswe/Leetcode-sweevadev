class Solution {
    public 
        List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(result, nums, new ArrayList<>(), 0);
        return result;
    }
    private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> current, int start){
        result.add(new ArrayList<>(current));
        
        for(int i = start; i<nums.length; i++){
            current.add(nums[i]);
            
            backtrack(result, nums, current, i + 1);
            
            current.remove(current.size()-1);
        }
    }
}