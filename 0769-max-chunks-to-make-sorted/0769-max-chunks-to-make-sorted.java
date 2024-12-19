class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int maxSeenSoFar = 0;
        for(int i = 0; i < arr.length; i++){
            maxSeenSoFar = Math.max(maxSeenSoFar, arr[i]);
            if(maxSeenSoFar == i){
                chunks++;
            }
        }
        return chunks;
    }
}