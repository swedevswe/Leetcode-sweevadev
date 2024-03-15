class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] output_arr = new int[N];
        
        
        int left = 1;
        for(int i = 0; i<N; i++){
            output_arr[i] = left;
            left = left*nums[i];
        }
        int right = 1;
            for(int i = N-1; i>=0; i--){
                output_arr[i] = output_arr[i]*right;
                right = right*nums[i];
            }
        return output_arr;
    }
}