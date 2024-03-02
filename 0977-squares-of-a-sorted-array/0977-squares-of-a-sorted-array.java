class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] output_arr = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;
        
        while(left<=right){
            int squareLeft = nums[left] * nums[left];
            int squareRight = nums[right] * nums[right];
            if(squareLeft>squareRight){
                output_arr[index] = squareLeft;
                left++;
            }else{
                output_arr[index] = squareRight;
                right--;
            }
            index--;
        }
        return output_arr;
        
    }
}