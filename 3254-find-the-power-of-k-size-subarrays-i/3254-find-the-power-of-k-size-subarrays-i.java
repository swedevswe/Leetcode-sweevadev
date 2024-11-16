class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(!deque.isEmpty() && deque.peekFirst() < i - k + 1){
                deque.pollFirst();
            }
            if(!deque.isEmpty() && nums[i] != nums[i-1] + 1){
                deque.clear();                                                          
            }
            deque.offerLast(i);
            if(i >= k - 1){
                if(deque.size() == k){
                    result[i - k + 1] = nums[deque.peekLast()];
                }else{
                    result[i - k + 1] = -1;
                }
            }
        }
        return result;
    }
}