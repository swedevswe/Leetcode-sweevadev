class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n+1];
        for(int i = 0; i < n; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        Deque<Integer> deque = new LinkedList<>();
        int minLen = Integer.MAX_VALUE;
        for(int j = 0; j < prefixSum.length; j++){
            while(!deque.isEmpty() && prefixSum[j] - prefixSum[deque.peekFirst()] >= k){
                minLen = Math.min(minLen, j - deque.pollFirst());
            }
            while(!deque.isEmpty() && prefixSum[j] <= prefixSum[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(j);
        }
        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }
}