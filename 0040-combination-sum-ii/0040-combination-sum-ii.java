class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
        
    }
    private void backtrack(int[] candidates, int remain, int start, List<Integer> curr, List<List<Integer>> result){
        if(remain == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i< candidates.length; i++){
            if(i > start && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > remain) break;
            
            curr.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i + 1, curr, result);
            curr.remove(curr.size() - 1);
            
        }
    }
    
}