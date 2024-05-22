class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(result, new ArrayList<>(), nums, 0);
        
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start){
        result.add(new ArrayList<>(current));
        
        for(int i = start; i < nums.length; i++){
            current.add(nums[i]);
            
            backtrack(result, current, nums, i + 1);
            
            current.remove(current.size()-1);
        }
    }
}