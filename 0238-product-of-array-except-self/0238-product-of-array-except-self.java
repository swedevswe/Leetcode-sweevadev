class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output_arr = new int[nums.length];
        
        int left = 1;
        for(int i = 0; i<nums.length; i++){
                output_arr[i] = left;
                left = nums[i] * left;
                
            }
        
        int right = 1;
        for(int i = nums.length-1; i>=0; i--){
                output_arr[i] = output_arr[i] * right;
                right = nums[i] * right;
            }
        
        return output_arr;
    }
}